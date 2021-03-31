package com.brault.jgtcv.simplecv.impl.tex.date

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode
import groovy.transform.BaseScript

@BaseScript
TexPrinterScript base

printer(SimpleDateNode) {

    def monthAbbreviations = [
            january: 'jan.',
            february: 'feb.',
            march: 'mar.',
            april: 'apr.',
            may: 'may',
            june: 'june',
            july: 'july',
            august: 'aug.',
            september: 'sep.',
            october: 'oct.',
            november: 'nov.',
            december: 'dec.'
    ]

    def abbreviateMonth = { String month ->
        monthAbbreviations.get(month.toLowerCase())
    }

    def formatMonth = { String month ->
        abbreviateMonth(month).capitalize()
    }

    // TODO: format each different combination

    def getDayMonth = {
        if (item.day.isPresent() && item.month.isPresent()) {
            return "${item.day.get()} ${formatMonth(item.month.get())}"
        } else if (item.month.isPresent()) {
            return "${formatMonth(item.month.get())}"
        } else {
            return ""
        }
    }

    if (item.year.isPresent()) {
        def dayMonth = getDayMonth()
        if (!dayMonth.isEmpty()) {
            tex "$dayMonth~${item.year.get()}"
        } else {
            tex "${item.year.get()}"
        }
    }

}

