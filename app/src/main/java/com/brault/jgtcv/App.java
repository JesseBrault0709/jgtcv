package com.brault.jgtcv;

import com.brault.jgtcv.api.JgtCv;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.tex.PrintedTex;
import picocli.CommandLine;

import picocli.CommandLine.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Command(name = "jgtcv", version = "jgtcv 0.0.1", mixinStandardHelpOptions = true)
public final class App implements Runnable {
    
    public static void main(String[] args) {
        final int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Parameters(index = "0", description = "The name of the CV script source file.")
    private File cvScript;

    @Option(names = {"--outFile", "-o"}, description = "The name of the main output TeX file.")
    private File outFile;

    @Override
    public void run() {
        try {
            final FileInputStream fis = new FileInputStream(this.cvScript);
            final String cvScript = new String(fis.readAllBytes());

            final JgtCv jgtcv = new JgtCv(cvScript);
            final CV cv = jgtcv.getCV();
            final PrintedTex printedCV = jgtcv.printTex(cv);
            if (this.outFile != null) {
                jgtcv.output(printedCV, this.outFile);
            } else {
                jgtcv.output(printedCV, new File("cv.tex"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

}
