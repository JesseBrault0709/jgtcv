package com.brault.jgtcv.simplecv.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.position.SimplePositionList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimplePositionList) {
    tex "\\cvSection{$item.sectionName}"
    item.positions.each {
        texln it
        texln "\\medskip \\goodbreak"
    }
}

