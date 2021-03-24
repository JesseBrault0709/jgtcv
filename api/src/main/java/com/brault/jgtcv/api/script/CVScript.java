package com.brault.jgtcv.api.script;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.tex.TexPrinter;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.lang.Script;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The base script for the user supplied CV scripts. Plugins may extend this and add additional methods
 * to the script.
 */
public abstract class CVScript extends Script {

    @Getter
    private final Collection<TexPrinter<?>> printers = new ArrayList<>();

    private Closure<?> cvClosure;

    public final void printers(Closure<?> cl) {

    }

    public final void cv(
            @DelegatesTo(value = CVBuilder.class, strategy = Closure.DELEGATE_FIRST)
            Closure<?> cl
    ) {
        this.cvClosure = cl;
    }

    public final CV getCV(CVBuilder b) {
        final Closure<?> rehydrated = this.cvClosure.rehydrate(b, this.cvClosure.getOwner(), this.cvClosure.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        return b.build();
    }

}
