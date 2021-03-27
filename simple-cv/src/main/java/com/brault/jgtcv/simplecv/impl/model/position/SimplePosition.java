package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.api.model.position.Duties;
import com.brault.jgtcv.simplecv.api.model.position.Position;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class SimplePosition implements Position {

    @NonNull
    String institution;

    @NonNull
    String role;

    @NonNull
    DateRange dateRange;

    Duties dutiesList;

    @Override
    public Optional<Duties> getDutiesList() {
        return Optional.ofNullable(this.dutiesList);
    }

}
