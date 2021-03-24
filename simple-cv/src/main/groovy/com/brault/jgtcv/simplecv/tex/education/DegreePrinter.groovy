package com.brault.jgtcv.simplecv.tex.education


import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.model.education.Degree
import com.brault.jgtcv.simplecv.model.education.RelevantCoursework
import groovy.transform.BaseScript

import static com.brault.jgtcv.simplecv.model.education.Degree.ExpandoFields.*;

@BaseScript
TexPrinterScript base

printer(Degree) {
    tex("\\datedItemWithDescription{$item.institution}{") << item.dateRange << "}{"

    if (item.major.isPresent()) {
        texln "\\descriptor{{\\it $item.degreeName,} ${item.major.get()}}"
    } else {
        texln "\\descriptor{{\\it $item.degreeName}}"
    }

    item.gpa.ifPresent({ gpa ->
        texln "\\descriptor{{\\sc gpa:} $gpa}"
    })

    item.getExtraBefore RELEVANT_COURSEWORK each {
        texln("\\descriptor{") << it << "}"
    }

    item.relevantCoursework.ifPresent({ relevantCoursework ->
        texln("\\descriptor{") << relevantCoursework << "}"
    })

    item.getExtraAfter RELEVANT_COURSEWORK each {
        texln("\\descriptor{") << it << "}"
    }

    texln "}" // close last arg to datedItemWithDescription
}

printer(RelevantCoursework) {
    tex "Relevant coursework: ${item.courses.join(", ")}"
}
