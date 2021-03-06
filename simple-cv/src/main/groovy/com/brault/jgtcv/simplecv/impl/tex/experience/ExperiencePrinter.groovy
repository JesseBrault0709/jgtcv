package com.brault.jgtcv.simplecv.impl.tex.experience

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleExperience) {
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

    texln "}" // close last arg of experience
}

