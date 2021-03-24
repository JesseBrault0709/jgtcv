package com.brault.jgtcv.api.plugin;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.api.tex.ScriptedTexPrinter;
import com.brault.jgtcv.api.tex.TexPrinter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Loads and manages "plugins", such as all available printers and the CVBuilder implementation.
 */
@ToString
public final class CVPluginManager {

    private static final Logger logger = LogManager.getLogger();

    private final Collection<TexPrinter<?>> printers = new ArrayList<>();
    private final CVBuilder cvBuilder;

    public CVPluginManager() {
        this.printers.addAll(ScriptedTexPrinter.getAllScriptedPrinters());

        final Optional<CVBuilder> cvBuilderOpt = CVBuilder.getImplementation();
        if (cvBuilderOpt.isPresent()) {
            this.cvBuilder = cvBuilderOpt.get();
        } else {
            throw new RuntimeException("Unable to find an implementation of CVBuilder");
        }
    }

    public final Collection<TexPrinter<?>> getPrinters() {
        return List.copyOf(this.printers);
    }

    public final CVBuilder getCVBuilder() {
        if (this.cvBuilder == null) {
            throw new NullPointerException("No CVBuilder was loaded by any plugin");
        }
        return this.cvBuilder;
    }

}
