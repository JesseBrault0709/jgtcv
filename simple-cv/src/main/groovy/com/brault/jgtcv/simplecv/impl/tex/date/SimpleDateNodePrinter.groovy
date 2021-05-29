package com.brault.jgtcv.simplecv.impl.tex.date

import com.brault.jgtcv.api.tex.TexPrinterScript
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode
import groovy.transform.BaseScript

import java.time.Month
import static java.time.Month.*

@BaseScript
TexPrinterScript base

printer(SimpleDateNode) {

    Map<Month, String> abbreviatedMonths = [
            (JANUARY): 'Jan.',
            (FEBRUARY): 'Feb.',
            (MARCH): 'Mar.',
            (APRIL): 'Apr.',
            (MAY): 'May',
            (JUNE): 'June',
            (JULY): 'July',
            (AUGUST): 'Aug.',
            (SEPTEMBER): 'Sep.',
            (OCTOBER): 'Oct.',
            (NOVEMBER): 'Nov.',
            (DECEMBER): 'Dec.'
    ]

    def formatMonthYear = { Month month, int year ->
        def abbreviatedMonth = abbreviatedMonths[month]
        if (abbreviatedMonth.endsWith(".")) {
            return "$abbreviatedMonth~$year"
        } else {
            return "$abbreviatedMonth $year"
        }
    }

    def asYear = item.asYear()
    def asYearMonth = item.asYearMonth()
    def asLocalDate = item.asLocalDate()

    // try most specific to least specific

    if (asLocalDate.isPresent()) {
        def localDate = asLocalDate.get()
        tex "${localDate.dayOfMonth} ${formatMonthYear(localDate.month, localDate.year)}"
    } else if (asYearMonth.isPresent()) {
        def yearMonth = asYearMonth.get()
        tex formatMonthYear(yearMonth.month, yearMonth.year)
    } else if (asYear.isPresent()) {
        def year = asYear.get()
        tex "${year.value}"
    }

}

