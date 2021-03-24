package com.brault.jgtcv;

import com.brault.jgtcv.api.JgtCv;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.tex.PrintedTexCV;

import java.io.IOException;
import java.io.InputStream;

public final class App {
    
    public static void main(String[] args) throws IOException {

        final InputStream scriptInputStream = App.class.getClassLoader().getResourceAsStream("cv2.groovy");
        final String cvScript = new String(scriptInputStream.readAllBytes());

        final JgtCv jgtcv = new JgtCv(cvScript);
        final CV cv = jgtcv.getCV();
        final PrintedTexCV printedCV = jgtcv.printCV(cv);
        jgtcv.output("cv.tex", printedCV);

    }
    
}
