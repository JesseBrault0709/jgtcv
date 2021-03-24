package com.brault.jgtcv.simplecv.model.position;

import com.brault.jgtcv.api.model.CVNode;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class Duties implements CVNode {

    @NonNull
    Collection<String> duties;

}
