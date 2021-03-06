package com.brault.jgtcv.simplecv.impl.tex.education

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegree
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDegree) {
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

    texln "}" // close last arg to datedItemWithDescription
}
