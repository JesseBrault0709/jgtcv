package com.brault.jgtcv.musiccv.impl.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.education.SimpleMusicDegree
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleMusicDegree) {
    tex("\\datedItemWithDescription{$item.institution}{")
    item.dateRange.ifPresent {
        tex it
    }
    tex "}{"

    if (item.major.isPresent()) {
        def major = item.major.get()
        texln "\\descriptor{"

        // TODO cleanup
        item.degreeName.ifPresent {
            tex "{\\it $it,} $major"
        }

    } else {

    }

    // TODO
}

