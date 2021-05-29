package com.brault.jgtcv.api.tex;

import groovy.lang.Closure;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A type of TexPrinter which uses a script to do the printing.
 *
 * @param <T> the type of object printed.
 */
public final class ScriptedTexPrinter<T> implements TexPrinter<T> {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Finds all scripts which subclass TexPrinterScript, runs these scripts,
     * and collects their return values, which should all be TexPrinters.
     *
     * @return A Collection of TexPrinters obtained from all available TexPrinterScripts.
     */
    public static Collection<TexPrinter<?>> getAllScriptedPrinters() {
        logger.traceEntry();

        try (final ScanResult scan = new ClassGraph().enableClassInfo().scan()) {

            // Get all scripts which subclass TexPrinterScript
            final ClassInfoList printerScripts = scan.getSubclasses(TexPrinterScript.class.getName());

            // Map all scripts to printers. Using flatMap() so that if there is an error we can ignore that script.
            final Collection<TexPrinter<?>> scriptedPrinters = printerScripts.stream()
                    .flatMap(printerScriptClassInfo -> {

                // unchecked cast okay because we only found subclasses of TexPrinterScript
                final Class<? extends TexPrinterScript> printerScriptClass =
                        (Class<? extends TexPrinterScript>) printerScriptClassInfo.loadClass();

                try {
                    final Constructor<? extends TexPrinterScript> constructor = printerScriptClass.getConstructor();
                    final TexPrinterScript printerScript = constructor.newInstance();
                    // run the script and get its return value
                    TexPrinter<?> printer = (TexPrinter<?>) printerScript.run(); // script must return a printer
                    if (printer == null) { // printer cannot be null
                        throw new RuntimeException("PrinterScript '" + printerScriptClass.getName() +
                                "' returned null; must return a TexPrinter.");
                    }
                    return Stream.<TexPrinter<?>>of(printer); // we are using flat map
                } catch (NoSuchMethodException e) {
                    logger.catching(Level.WARN, e);
                    logger.warn("unable to obtain constructor for PrinterScript '" + printerScriptClass.getName() +
                            "'; see stacktrace above.");
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    logger.catching(Level.WARN, e);
                    logger.warn("unable to instantiate PrinterScript '" + printerScriptClass.getName() +
                            "'; see stacktrace above.");
                }
                return Stream.empty(); // we are using flat map
            }).collect(Collectors.toList());

            return logger.traceExit(scriptedPrinters);
        }
    }

    private final Class<T> printerFor;
    private final Closure<?> printerClosure;

    public ScriptedTexPrinter(
            Class<T> printerFor,
            Closure<?> printerClosure
    ) {
        this.printerFor = printerFor;
        this.printerClosure = printerClosure;
    }

    @Override
    public Class<T> getPrinterFor() {
        return this.printerFor;
    }

    @Override
    public String printTex(TexPrintingContext context, T item) {
        final var delegate = new TexBuilder<>(context, item);
        final Closure<?> rehydrated = this.printerClosure.rehydrate(delegate, this.printerClosure.getOwner(),
                this.printerClosure.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        return delegate.build();
    }

}
