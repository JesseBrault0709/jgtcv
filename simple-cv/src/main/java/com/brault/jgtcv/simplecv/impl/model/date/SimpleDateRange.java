package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class SimpleDateRange implements CVNode, DateRange {

    @NonNull
    DateNode start;

    DateNode end;

    boolean toPresent;

    @Override
    public Optional<DateNode> getEnd() {
        return Optional.ofNullable(this.end);
    }

}
