package com.brault.jgtcv.simplecv.model.date;

import com.brault.jgtcv.api.model.CVNode;
import lombok.NonNull;
import lombok.Value;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Value
public class DateRange implements CVNode {

    @NonNull
    DateNode start;

    DateNode end;

    boolean toPresent;

    public Optional<DateNode> getEnd() {
        return Optional.ofNullable(this.end);
    }

}
