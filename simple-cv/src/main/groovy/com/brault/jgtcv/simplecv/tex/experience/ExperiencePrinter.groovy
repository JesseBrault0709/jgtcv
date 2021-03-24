package com.brault.jgtcv.simplecv.tex.experience

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.experience.SimpleExperience
import groovy.transform.BaseScript

import static com.brault.jgtcv.simplecv.model.experience.SimpleExperience.ExpandoFields.*;

@BaseScript
TexPrinterScript base

printer(SimpleExperience) {
    tex("\\experience{$item.institution}{") << item.date << "}{"
    item.role.ifPresent({ role ->
        tex role
    })
    tex "}{"


    item.getExtraBefore DESCRIPTION each {
        texln it
    }

    item.description.ifPresent({ description ->
        texln description
    })

    item.getExtraAfter DESCRIPTION each {
        texln it
    }

    texln "}" // close last arg of experience
}

