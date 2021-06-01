package com.brault.jgtcv.musiccv.impl.tex.experience

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.experience.SimpleMusicExperience
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleMusicExperience) {
    // TODO: reuse code from SimpleExperiencePrinter

    tex("\\experience{$item.institution}{") << item.date << "}{"
    item.role.ifPresent {
        tex it
    }
    tex "}{"

    item.description.ifPresent {
        texln it
    }

    item.duties.ifPresent {
        texln it
    }

    texln item.works

    texln "}" // close last arg of experience
}