package com.brault.jgtcv.musiccv.impl.tex.education

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.musiccv.impl.model.education.SimpleMusicDegree
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleMusicDegree) {
    // TODO: figure out how to reuse code from another printer

    tex("\\datedItemWithDescription{$item.institution}{")

    item.dateRange.ifPresent {
        tex it
    }

    tex "}{"

    if (item.major.isPresent()) {
        texln "\\descriptor{{\\it $item.degreeName,} ${item.major.get()}}"
    } else {
        texln "\\descriptor{{\\it $item.degreeName}}"
    }

    item.gpa.ifPresent {
        texln "\\descriptor{{\\sc gpa:} $it}"
    }

    item.relevantCoursework.ifPresent{
        texln("\\descriptor{") << it << "}"
    }

    // NEW CODE
    if (item.privateTeachers.size() > 0) {
        texln "\\descriptor{Private teachers: ${item.privateTeachers.join(", ")}}"
    }
    // END NEW CODE

    texln "}" // close last arg to datedItemWithDescription
}