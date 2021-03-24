package com.brault.jgtcv.simplecv.model.date;

import java.util.Map;

public final class DateRangeBuilder {

    private DateNode start;
    private DateNode end;
    boolean toPresent;

    public DateRangeBuilder start(Map<String, ?> date) {
        this.start = DateNode.fromMap(date);
        return this;
    }

    public DateRangeBuilder end(Map<String, ?> date) {
        this.end = DateNode.fromMap(date);
        return this;
    }

    public DateRangeBuilder toPresent(boolean toPresent) {
        this.toPresent = toPresent;
        return this;
    }

    public DateRange build() {
        return new DateRange(this.start, this.end, this.toPresent);
    }

}
