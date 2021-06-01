package com.brault.jgtcv.musiccv.impl.tex.musicalwork

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorksList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleWorksList) {

    tex "\\smallskip"

    item.works.each {
        texln it
    }
}