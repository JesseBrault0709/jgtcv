package com.brault.jgtcv.simplecv.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.position.SimplePosition
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimplePosition) {
    tex("\\datedItemWithDescription{$item.institution}{") << item.dateRange << "}{"

    texln "\\descriptor{${item.role.capitalize()}}"

    item.dutiesList.ifPresent({ duties ->
        if (item.dateRange.toPresent) {
            texln "\\descriptor{\\it Duties include:}"
        } else {
            texln "\\descriptor{\\it Duties included:}"
        }

        texln "\\descriptor{"
        texln duties
        texln "}" // close duties descriptor
    })

    texln "}" // close datedItem
}

