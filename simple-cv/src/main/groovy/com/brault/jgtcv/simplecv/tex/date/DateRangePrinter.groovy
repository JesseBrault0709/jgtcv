package com.brault.jgtcv.simplecv.tex.date

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.date.DateRange
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(DateRange) {
    tex(item.start) << "--"
    if (item.toPresent) {
        tex "Present"
    } else {
        item.end.ifPresent({ end ->
            tex end
        })
    }
}