package com.brault.jgtcv.simplecv.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.position.PositionList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(PositionList) {
    tex "\\cvSection{$item.sectionName}"
    item.positions.each {
        texln it
        texln "\\medskip \\goodbreak"
    }
}

