package com.brault.jgtcv.simplecv.tex.date

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRange
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDateRange) {
    tex(item.start) << "--"
    if (item.toPresent) {
        tex "Present"
    } else {
        item.end.ifPresent({ end ->
            tex end
        })
    }
}