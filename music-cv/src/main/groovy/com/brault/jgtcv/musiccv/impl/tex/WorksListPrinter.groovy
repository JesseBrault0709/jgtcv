package com.brault.jgtcv.musiccv.impl.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorksList
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(SimpleWorksList) {

    context.loadMacroFileSource("tex/musicMacros.tex", "musicMacros")

    tex "\\smallskip"

    item.works.each {
        texln it
    }
}

printer(SimpleWork) {
    tex("\\work{${transformDiacritics(item.composer)}}{") << item.title << "}"
}

printer(SimpleWorkTitle) {

    def formatWorkNumber = { String title ->
        if (title.contains("no. ")) {
            return title.replace("no. ", "no.~")
        } else {
            return title
        }
    }

    if (item.italicized) {
        tex "\\it ${transformDiacritics(formatWorkNumber(item.title))}"
    } else {
        tex transformDiacritics(formatWorkNumber(item.title))
    }
}