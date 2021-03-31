package com.brault.jgtcv;

import com.brault.jgtcv.api.JgtCv;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.tex.PrintedTexCV;
import picocli.CommandLine;

import picocli.CommandLine.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Command(name = "jgtcv", version = "jgtcv 0.0.1", mixinStandardHelpOptions = true)
public final class App implements Runnable {
    
    public static void main(String[] args) {
        final int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Parameters(index = "0", description = "Path to the CV source file.")
    private String cvSourcePath;

    @Option(names = {"--outFile", "-o"}, description = "The name of the output TeX file.")
    private String outputFileName;

    @Override
    public void run() {
        try {
            final InputStream scriptInputStream = Files.newInputStream(Paths.get(this.cvSourcePath));
            final String cvScript = new String(scriptInputStream.readAllBytes());

            final JgtCv jgtcv = new JgtCv(cvScript);
            final CV cv = jgtcv.getCV();
            final PrintedTexCV printedCV = jgtcv.printCV(cv);
            if (this.outputFileName != null) {
                jgtcv.output(this.outputFileName, printedCV);
            } else {
                jgtcv.output("cv.tex", printedCV);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

}
