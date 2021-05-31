package com.brault.jgtcv.api.model.duties;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Collection;

public interface Duties extends CVNode {

    interface Builder extends CVNodeBuilder<Duties> {
        Builder duty(String duty);
        Builder duties(Collection<String> duties);
        Collection<String> duties();

        Builder presentTense(boolean presentTense);
        boolean presentTense();
    }

    Collection<String> getDuties();
    boolean isPresentTense();

}
