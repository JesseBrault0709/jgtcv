package com.brault.jgtcv.api.tex;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.lang.Script;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The base script for all plugin/user supplied printing scripts.
 *
 * Each script must return a TexPrinter object; this can be accomplished by calling
 * printer(Class, Closure) as the final expression in the script.
 */
public abstract class TexPrinterScript extends Script {

    /**
     * N.B.: tex() should be called first in any printer, before any calls to texln()
     * or other methods which start on a new line; see the TexBuilder class.
     *
     * @param printerFor The class of the object to be printed
     * @param cl The closure containing the actual printer code
     * @param <T> The type of the object to be printed
     */
    public <T> TexPrinter<T> printer(
            Class<T> printerFor,
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, type = "com.brault.jgtcv.api.tex.TexBuilder<T>")
            Closure<?> cl
    ) {
        return new ScriptedTexPrinter<>(printerFor, cl);
    }

}
