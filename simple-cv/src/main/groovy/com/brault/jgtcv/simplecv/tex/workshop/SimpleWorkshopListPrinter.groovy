package com.brault.jgtcv.simplecv.tex.workshop

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.api.model.workshop.WorkshopList
import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshopList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleWorkshopList) {
    tex "\\cvSection{$item.sectionName}"
    item.workshops.each {
        texln it
        texln "\\medskip"
    }
}

