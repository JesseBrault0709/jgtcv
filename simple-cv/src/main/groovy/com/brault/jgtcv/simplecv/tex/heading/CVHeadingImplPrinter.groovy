package com.brault.jgtcv.simplecv.tex.heading

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.heading.CVHeading
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(CVHeading) {
    tex "\\headingBig{$item.name}"
    texln "\\headingSmall{$item.professionalTitle}"
    item.documentTitle.ifPresent({ documentTitle ->
        texln "\\smallskip"
        texln "\\centerline{\\bf $documentTitle}"
    })
}
