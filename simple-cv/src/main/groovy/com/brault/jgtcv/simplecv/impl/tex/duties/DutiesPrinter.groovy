package com.brault.jgtcv.simplecv.impl.tex.duties

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDuties
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDuties) {

    tex "\\descriptor{\\it Duties "
    if (item.isPresentTense()) {
        tex "include"
    } else {
        tex "included"
    }
    tex ":}" // close descriptor

    texln "\\descriptor{"

    item.duties.each {
        texln "\\item {\$\\bullet\$} $it"
    }

    texln "}" // close descriptor

}

