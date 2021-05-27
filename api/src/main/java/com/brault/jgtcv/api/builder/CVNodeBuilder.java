package com.brault.jgtcv.api.builder;

import com.brault.jgtcv.api.model.node.CVNode;
import groovy.lang.Closure;

import java.util.function.Supplier;

public interface CVNodeBuilder<T extends CVNode> {

    static <T extends CVNode, B extends CVNodeBuilder<T>> T buildWithClosure(Closure<?> cl, Supplier<B> builderSupplier) {
        final B builder = builderSupplier.get();
        final Closure<?> rehydrated = cl.rehydrate(builder, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        return builder.build();
    }

    T build();
}
