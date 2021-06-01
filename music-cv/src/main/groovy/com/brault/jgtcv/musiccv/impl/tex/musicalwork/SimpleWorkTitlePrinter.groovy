package com.brault.jgtcv.musiccv.impl.tex.musicalwork

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorkTitle
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(SimpleWorkTitle) {

    def formatWorkNumber = { String title ->
        if (title.contains("no. ")) {
            return title.replace("no. ", "no.~")
        } else {
            return title
        }
    }

    tex transformDiacritics(formatWorkNumber(item.title))
}