package com.brault.jgtcv.simplecv.tex.experience

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.experience.ExperienceList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(ExperienceList) {
    tex "\\cvSection{$item.sectionName}"
    texlnNodes nodes: item.experiences, separator: "\\medskip \\goodbreak"
}

