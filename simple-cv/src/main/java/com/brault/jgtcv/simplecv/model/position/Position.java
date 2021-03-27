package com.brault.jgtcv.simplecv.model.position;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class Position implements CVNode {

    @NonNull
    String institution;

    @NonNull
    String role;

    @NonNull
    DateRange dateRange;

    Duties dutiesList;

    public Optional<Duties> getDutiesList() {
        return Optional.ofNullable(this.dutiesList);
    }

}
