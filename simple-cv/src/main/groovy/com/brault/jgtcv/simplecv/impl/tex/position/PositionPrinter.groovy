package com.brault.jgtcv.simplecv.impl.tex.position

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.position.SimplePosition
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimplePosition) {
    tex("\\datedItemWithDescription{$item.institution}{") << item.dates << "}{"

    texln "\\descriptor{${item.role.capitalize()}}"

    item.duties.ifPresent({ duties ->
        texln duties
    })

    texln "}" // close datedItem
}

