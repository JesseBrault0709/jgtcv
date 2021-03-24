package com.brault.jgtcv.api.tex;

/**
 * Prints an object.
 *
 * @param <T> The type of the object to be printed.
 */
public interface TexPrinter<T> {

    Class<T> getPrinterFor();
    String printTex(TexPrintingContext context, T t);

}
