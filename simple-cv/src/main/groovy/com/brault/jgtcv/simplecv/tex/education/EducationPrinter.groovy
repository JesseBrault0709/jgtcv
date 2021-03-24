package com.brault.jgtcv.simplecv.tex.education

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.education.Education
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(Education) {
    tex "\\cvSection{$item.sectionName}"

    texlnNodes nodes: item.degrees, separator: "\\medskip \\goodbreak"

}

