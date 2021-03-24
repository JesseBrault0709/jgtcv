package com.brault.jgtcv.musiccv.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.education.PrivateTeacherList
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(PrivateTeacherList) {
    tex "Private teachers: ${item.names.join(", ")}"
}

