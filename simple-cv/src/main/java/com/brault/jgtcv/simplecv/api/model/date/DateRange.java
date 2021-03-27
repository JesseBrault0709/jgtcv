package com.brault.jgtcv.simplecv.api.model.date;

import com.brault.jgtcv.simplecv.api.model.date.DateNode;

import java.util.Optional;

public interface DateRange {

    DateNode getStart();
    Optional<DateNode> getEnd();
    boolean isToPresent();

}
