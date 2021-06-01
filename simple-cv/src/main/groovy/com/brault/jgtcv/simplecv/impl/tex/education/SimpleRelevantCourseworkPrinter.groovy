package com.brault.jgtcv.simplecv.impl.tex.education

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.education.SimpleRelevantCoursework
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleRelevantCoursework) {
    tex "Relevant coursework: ${item.courses.join(", ")}"
}