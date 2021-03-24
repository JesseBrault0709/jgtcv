package com.brault.jgtcv.api.tex;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.lang.Script;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The base script for all plugin/user supplied printing scripts.
 */
public abstract class TexPrinterScript extends Script {

    private final Map<Class<?>, Closure<?>> printersForAndClosures = new HashMap<>();

    public TexPrinterScript() {
        super();
        this.run();
    }

    /**
     * N.B.: tex() should be called first in any printer, before any calls to texln()
     * or other methods which start on a new line; see the TexBuilder class.
     *
     * @param printerFor The class of the object to be printed
     * @param cl The closure containing the actual printer code
     * @param <T> The type of the object to be printed
     */
    public <T> void printer(
            Class<T> printerFor,
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, type = "com.brault.jgtcv.api.tex.TexBuilder<T>")
            Closure<?> cl
    ) {
        this.printersForAndClosures.put(printerFor, cl);
    }

    /**
     * Returns all printers contained in this script.
     */
    public Collection<TexPrinter<?>> getPrinters() {
        return this.printersForAndClosures.entrySet().stream().map(entry -> {
            final var printerFor = entry.getKey();
            final var cl = entry.getValue();
            final TexPrinter<?> printer = new ScriptedTexPrinter<>(printerFor, cl);
            return printer;
        }).collect(Collectors.toList());
    }

}
