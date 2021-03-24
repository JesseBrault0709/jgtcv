package com.brault.jgtcv.musiccv.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.musicalwork.Work
import com.brault.jgtcv.musiccv.musicalwork.WorkTitle
import com.brault.jgtcv.musiccv.musicalwork.WorksList
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(WorksList) {

    context.loadMacroFileSource("tex/musicMacros.tex", "musicMacros")

    tex "\\smallskip"

    item.works.each {
        texln it
    }
}

printer(Work) {
    tex("\\work{${transformDiacritics(item.composer)}}{") << item.title << "}"
}

printer(WorkTitle) {

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