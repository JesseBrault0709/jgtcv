package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.simplecv.api.model.position.Duties;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class SimpleDuties implements Duties {

    @NonNull
    Collection<String> duties;

}
