package com.brault.jgtcv.api.model.duties;

import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Collection;

public interface Duties extends CVNode {

    Collection<String> getDuties();
    boolean isPresentTense();

}
