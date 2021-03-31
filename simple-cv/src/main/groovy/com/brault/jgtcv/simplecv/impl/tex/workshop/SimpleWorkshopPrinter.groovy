package com.brault.jgtcv.simplecv.impl.tex.workshop

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshop
import groovy.transform.BaseScript

import static com.brault.jgtcv.api.tex.TexPrinterUtils.transformDiacritics

@BaseScript
TexPrinterScript base

printer(SimpleWorkshop) {
    tex("\\datedItemWithDescription{$item.workshopName}{") << item.date << "}{"

    item.location.ifPresent { location ->
        texln "\\descriptor{$location}"
    }

    if (item.instructors.size() > 0) {
        texln "\\descriptor{Instructors: ${transformDiacritics(item.instructors.join(", "))}}"
    }

    texln "}" // closing datedItemWithDescription
}