package com.brault.jgtcv.simplecv.impl.tex.education

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.education.SimpleEducation
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleEducation) {
    tex "\\cvSection{$item.sectionName}"

    texlnNodes nodes: item.degrees, separator: "\\medskip \\goodbreak"
}

