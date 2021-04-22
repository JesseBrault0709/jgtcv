package com.brault.jgtcv.simplecv.api.model.duties;

import com.brault.jgtcv.api.model.CVNode;

import java.util.Collection;

public interface Duties extends CVNode {

    Collection<String> getDuties();
    boolean isPresentTense();

}
