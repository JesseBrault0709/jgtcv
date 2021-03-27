package com.brault.jgtcv.simplecv.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.SimpleCV
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleCV) {
    // load main macros file
    context.loadMacroFileSource("tex/macros.tex", "macros")

    item.sections.each {
        tex it
        texln "\\bigskip \\goodbreak"
    }

    // must run after everything
    context.macroFileNamesAndSources.keySet().each {
        prependTex "\\input $it \n"
    }

    texln "\\bye"

}