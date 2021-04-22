package com.brault.jgtcv.api;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.api.model.CV;

import com.brault.jgtcv.api.script.CVScript;
import com.brault.jgtcv.api.tex.PrintedTex;
import com.brault.jgtcv.api.tex.ScriptedTexPrinter;
import com.brault.jgtcv.api.tex.TexPrinter;
import com.brault.jgtcv.api.tex.TexPrintingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.groovy.control.CompilerConfiguration;

import groovy.lang.GroovyShell;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * The main gateway-class to the library. Use this in the app project.
 */
public final class JgtCv {
    
    private static final Logger logger = LogManager.getLogger();

    private final CVScript script;

    private final CVBuilder cvBuilder;
    private final Collection<TexPrinter<?>> printers = new ArrayList<>();

    public JgtCv(String scriptSource) {
        logger.traceEntry();

        final GroovyShell shell = new GroovyShell(this.getClass().getClassLoader(), new CompilerConfiguration());
        this.script = (CVScript) shell.parse(scriptSource);
        this.script.run();

        final Optional<CVBuilder> cvBuilderOpt = CVBuilder.getImplementation();
        if (cvBuilderOpt.isPresent()) {
            this.cvBuilder = cvBuilderOpt.get();
        } else {
            throw new RuntimeException("Unable to find an implementation of CVBuilder");
        }

        this.printers.addAll(ScriptedTexPrinter.getAllScriptedPrinters());

        logger.traceExit();
    }

    public CV getCV() {
        logger.traceEntry();
        final CV result = script.getCV(this.cvBuilder);
        return logger.traceExit(result);
    }

    /**
     * Parses and runs the given script source and returns a CV object.
     *
     * @param scriptSource the source code of the CV script
     * @return a CV object
     *
     * TODO: Make it return an Optional in case it fails
     */
    @Deprecated
    public CV fromScript(String scriptSource) {
        logger.traceEntry(); // script source may be very long, don't put it in output

        final CompilerConfiguration cc = new CompilerConfiguration();

        final GroovyShell shell = new GroovyShell(this.getClass().getClassLoader(), cc);

        final CVScript script = (CVScript) shell.parse(scriptSource);
        script.getCV(this.cvBuilder);
        script.run();

        return logger.traceExit(cvBuilder.build());
    }

    /**
     * Takes the given CV object and returns a PrintedTexCV, i.e., a container result.
     *
     * @param cv the CV to be printed
     * @return the result of printing the given CV
     */
    public PrintedTex printTex(CV cv) {
        final TexPrintingContext context = new TexPrintingContext(this.printers);
        final Optional<TexPrinter<CV>> cvTexPrinterOpt = context.getPrinterFor(cv);
        if (cvTexPrinterOpt.isEmpty()) {
            throw new RuntimeException("There is no available TexPrinter for target class " + cv.getClass().getName());
        }
        final TexPrinter<CV> cvTexPrinter = cvTexPrinterOpt.get();
        final String cvSource = cvTexPrinter.printTex(context, cv);
        return new PrintedTex(cvSource, context.getMacroFileNamesAndSources());
    }

    /**
     * Outputs the given print result to the given File, writing any other files
     * to the same directory.
     *
     * @param printedTex The printed TeX.
     * @param outputFile The file to which to write the main TeX source file.
     */
    public void output(PrintedTex printedTex, File outputFile) {
        logger.traceEntry();

        logger.debug("opening FileOutputStream for file {}", outputFile);
        try (final FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(printedTex.getSource().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final var absoluteOutputFile = outputFile.getAbsoluteFile();
        logger.debug("absoluteOutputFile: {}", absoluteOutputFile);
        final var outputParentFile = absoluteOutputFile.getParentFile();
        logger.debug("outputParentFile: {}", outputParentFile);
        final var outputDir = outputFile.getAbsoluteFile().getParentFile();
        logger.debug("outputDir: {}", outputDir);

        printedTex.getMacroFileNamesAndSources().forEach((fileName, source) -> {
            final var macroOutputFile = new File(outputDir.getAbsolutePath() + File.separator + fileName + ".tex");
            logger.debug("Opening FileOutputStream for file {}", macroOutputFile);
            try (final FileOutputStream fos = new FileOutputStream(macroOutputFile)) {
                fos.write(source.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        logger.traceExit();
    }

}
