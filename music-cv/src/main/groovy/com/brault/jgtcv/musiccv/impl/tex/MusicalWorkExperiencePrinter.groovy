package com.brault.jgtcv.musiccv.impl.tex

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.experience.SimpleMusicalWorkExperience
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleMusicalWorkExperience) {
    tex("\\experience{")
    tex item.work.title
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

    item.duties.ifPresent {
        texln it
    }

    texln "}"
}
