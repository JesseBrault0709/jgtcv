package com.brault.jgtcv.musiccv.impl.tex.musicalwork

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWork
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(SimpleWork) {
    context.loadMacroFileSource("tex/musicMacros.tex", "musicMacros")

    tex("\\work{${transformDiacritics(item.composer)}}{") << item.title << "}"
}

