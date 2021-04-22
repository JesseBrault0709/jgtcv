package com.brault.jgtcv.simplecv.impl.model.duties;

import com.brault.jgtcv.simplecv.api.model.duties.Duties;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class SimpleDuties implements Duties {

    @NonNull
    Collection<String> duties;

    boolean presentTense;

}
