package com.brault.jgtcv.simplecv.impl.tex.heading

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.heading.SimpleCVHeading
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleCVHeading) {
    tex "\\headingBig{$item.name}"
    texln "\\headingSmall{$item.professionalTitle}"
    item.documentTitle.ifPresent({ documentTitle ->
        texln "\\smallskip"
        texln "\\centerline{\\bf $documentTitle}"
    })
}
