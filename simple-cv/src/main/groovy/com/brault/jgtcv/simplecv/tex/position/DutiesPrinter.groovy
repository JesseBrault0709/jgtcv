package com.brault.jgtcv.simplecv.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.position.Duties
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(Duties) {
    item.duties.each {
        tex "\\item {\$\\bullet\$} $it"
    }
}

