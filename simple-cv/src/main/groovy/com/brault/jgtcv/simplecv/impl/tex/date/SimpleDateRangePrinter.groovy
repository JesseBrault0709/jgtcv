package com.brault.jgtcv.simplecv.impl.tex.date

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeNode
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDateRangeNode) {
    item.start.ifPresent {
        tex it
    }
    tex "--"
    if (item.end.isPresent()) {
        tex item.end.get()
    } else {
        tex "Present"
    }
}