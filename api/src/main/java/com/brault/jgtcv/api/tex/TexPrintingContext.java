package com.brault.jgtcv.api.tex;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.brault.jgtcv.api.plugin.CVPluginManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class describes a printing context which is available to all printers
 * during a given printing, i.e., it should be carried between printers as the CV
 * is traversed.
 */
public final class TexPrintingContext {

    private static final Logger logger = LogManager.getLogger();

    private final Collection<String> loadedResources = new ArrayList<>();
    private final Map<String, String> macroFileNamesAndSources = new LinkedHashMap<>();
    private final Collection<TexPrinter<?>> printers = new ArrayList<>();

    public TexPrintingContext(Collection<? extends TexPrinter<?>> printers) {
        this.printers.addAll(printers);
    }

    /**
     * WARNING: if there is already a source associated with the given fileName, the new source will
     * overwrite the previous source.
     * 
     * @param fileName the name of the macro file as it would appear in a TeX file's <code>\input</code> command
     * @param source the source string of the macros
     * @return this
     */
    public TexPrintingContext addMacroFileSource(String fileName, String source) {
        this.macroFileNamesAndSources.put(fileName, source);
        return this;
    }

    /**
     * Note: this method checks if the resource has already been loaded; if so, it does not reload it.
     * 
     * @param resourcePath the path to the resource to load
     * @param macroFileName the name of the macro file as it would appear in a TeX file's <code>\input</code> command
     * @return this
     */
    public final TexPrintingContext loadMacroFileSource(String resourcePath, String macroFileName) {
        if (!this.loadedResources.contains(resourcePath)) {
            try {
                final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
                final String source = new String(inputStream.readAllBytes());
                this.addMacroFileSource(macroFileName, source);
                inputStream.close();
                this.loadedResources.add(resourcePath);
            } catch (IOException e) {
                logger.error("Error while loading macroFile: {}", e);
            }
        }
        return this;
    }

    /**
     * Returns the loaded macro files' names and their sources.
     */
    public final Map<String, String> getMacroFileNamesAndSources() {
        return Map.copyOf(this.macroFileNamesAndSources);
    }

    /**
     * Retrieves a TexPrinter for the given object.
     *
     * @param t the object to be printed
     * @param <T> the type of the object to be printed
     * @return an optional TexPrinter
     */
    public final <T> Optional<TexPrinter<T>> getPrinterFor(T t) {
        final Class<?> tClass = t.getClass();
        final Optional<TexPrinter<?>> printerOpt = this.printers.stream()
                .filter(printer -> printer.getPrinterFor().equals(tClass))
                .findAny();

        if (printerOpt.isEmpty()) {
            return Optional.empty();
//            throw new RuntimeException("There is no TexPrinter for target class " + t.getClass().getName());
        } else {
            return Optional.of((TexPrinter<T>) printerOpt.get()); // okay because we filtered for printerFor == tClass
        }
    }

}
