package com.brault.jgtcv.musiccv.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.experience.MusicalWorkExperience
import groovy.transform.BaseScript


@BaseScript
TexPrinterScript base

printer(MusicalWorkExperience) {
    tex("\\experience{")
    if (item.work.title.italicized) {
        tex "{\\boldItalic $item.work.title.title}"
    } else {
        tex item.work.title.title
    }
    tex("}{") << item.date << "}{"
    item.role.ifPresent({ role ->
        tex role
    })
    tex "}{"

    item.description.ifPresent({ description ->
        texln description
    })

    texln "\\smallskip"

    texln item.work

    texln "}"
}
