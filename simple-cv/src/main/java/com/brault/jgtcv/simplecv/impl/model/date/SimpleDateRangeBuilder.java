package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;

import java.util.Map;

public final class SimpleDateRangeBuilder {

    private DateNode start;
    private DateNode end;
    boolean toPresent;

    public SimpleDateRangeBuilder start(Map<String, ?> date) {
        this.start = SimpleDateNode.fromMap(date);
        return this;
    }

    public SimpleDateRangeBuilder end(Map<String, ?> date) {
        this.end = SimpleDateNode.fromMap(date);
        return this;
    }

    public SimpleDateRangeBuilder toPresent(boolean toPresent) {
        this.toPresent = toPresent;
        return this;
    }

    public DateRange build() {
        return new SimpleDateRange(this.start, this.end, this.toPresent);
    }

}
