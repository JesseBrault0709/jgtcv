package com.brault.jgtcv.simplecv.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.position.SimpleDuties
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDuties) {
    item.duties.each {
        tex "\\item {\$\\bullet\$} $it"
    }
}

