package com.brault.jgtcv.simplecv.model.date;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Value
public class DateNode implements CVNode {

    public static DateNode fromMap(Map<String, ?> map) {
        final Integer day = (Integer) map.get("day");
        final String month = (String) map.get("month");
        final Integer year = (Integer) map.get("year");
        return new DateNode(day, month, year);
    }

    Integer day;
    String month;
    Integer year;

    public Optional<Integer> getDay() {
        return Optional.ofNullable(this.day);
    }

    public Optional<String> getMonth() {
        return Optional.ofNullable(this.month);
    }

    public Optional<Integer> getYear() {
        return Optional.ofNullable(this.year);
    }

}
