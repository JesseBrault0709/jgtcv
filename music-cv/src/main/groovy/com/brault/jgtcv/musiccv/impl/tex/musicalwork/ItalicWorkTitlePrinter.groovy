package com.brault.jgtcv.musiccv.impl.tex.musicalwork

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.musicalwork.ItalicWorkTitle
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(ItalicWorkTitle) {
    tex "\\it ${transformDiacritics(item.title)}"
}


