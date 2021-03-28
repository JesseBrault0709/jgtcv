package com.brault.jgtcv.musiccv.model.musicalwork;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WorksListBuilder {

    private final Collection<Work> works = new LinkedList<>();

    public WorksListBuilder work(
            @DelegatesTo(value = WorkBuilder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new WorkBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        this.works.add(b.build());
        return this;
    }

    public WorksListBuilder work(Map<String, Object> args) {
        this.works.add(Work.fromMap(args));
        return this;
    }

    public WorksList build() {
        return new WorksList(List.copyOf(this.works));
    }

}
