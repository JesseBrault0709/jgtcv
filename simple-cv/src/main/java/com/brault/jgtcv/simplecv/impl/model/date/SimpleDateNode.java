package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import lombok.Value;

import java.util.Map;
import java.util.Optional;

@Value
public class SimpleDateNode implements CVNode, DateNode {

    public static DateNode fromMap(Map<String, ?> map) {
        final Integer day = (Integer) map.get("day");
        final String month = (String) map.get("month");
        final Integer year = (Integer) map.get("year");
        return new SimpleDateNode(day, month, year);
    }

    Integer day;
    String month;
    Integer year;

    @Override
    public Optional<Integer> getDay() {
        return Optional.ofNullable(this.day);
    }

    @Override
    public Optional<String> getMonth() {
        return Optional.ofNullable(this.month);
    }

    @Override
    public Optional<Integer> getYear() {
        return Optional.ofNullable(this.year);
    }

}
