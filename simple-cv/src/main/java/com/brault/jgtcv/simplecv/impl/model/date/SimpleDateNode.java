package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.api.model.date.DateNode;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleDateNode implements DateNode {

    public static DateNode fromMap(Map<String, ?> map) {
        final Integer day = (Integer) map.get("day");
        final String month = (String) map.get("month");
        final Integer year = (Integer) map.get("year");

        if (day != null && month != null && year != null) {

            final Month m = Month.valueOf(month.toUpperCase());

            final LocalDate localDate = LocalDate.of(year, m, day);
            final YearMonth ym = YearMonth.of(year, m);
            final Year y = Year.of(year);

            return new SimpleDateNode(y, ym, localDate);

        } else if (month != null && year != null) {

            final Month m = Month.valueOf(month.toUpperCase());

            final YearMonth ym = YearMonth.of(year, m);
            final Year y = Year.of(year);

            return new SimpleDateNode(y, ym, null);

        } else if (year != null) {

            final Year y = Year.of(year);
            return new SimpleDateNode(y, null, null);

        } else {
            throw new IllegalArgumentException("Invalid date map: " + map);
        }
    }

    private final Year year;
    private final YearMonth yearMonth;
    private final LocalDate localDate;

    public SimpleDateNode(Year year) {
        this.year = year;
        this.yearMonth = null;
        this.localDate = null;
    }

    public SimpleDateNode(YearMonth yearMonth) {
        this.year = Year.of(yearMonth.getYear());
        this.yearMonth = yearMonth;
        this.localDate = null;
    }

    public SimpleDateNode(LocalDate localDate) {
        this.year = Year.of(localDate.getYear());
        this.yearMonth = YearMonth.of(localDate.getYear(), localDate.getMonth());
        this.localDate = localDate;
    }

    @Override
    public Optional<Year> asYear() {
        return Optional.ofNullable(this.year);
    }

    @Override
    public Optional<YearMonth> asYearMonth() {
        return Optional.ofNullable(this.yearMonth);
    }

    @Override
    public Optional<LocalDate> asLocalDate() {
        return Optional.ofNullable(this.localDate);
    }

}
