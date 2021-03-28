package com.brault.jgtcv.musiccv.model.musicalwork;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class WorkBuilder {
    
    private WorkTitle title;
    private String composer;
    private String movements;

    public WorkBuilder composer(String composer) {
        this.composer = composer;
        return this;
    }

    public WorkBuilder title(String title, boolean italicized) {
        this.title = new WorkTitle(title, italicized);
        return this;
    }

    public WorkBuilder title(String title) {
        return this.title(title, false);
    }

    public WorkBuilder title(
            String title,
            @DelegatesTo(value = WorkTitleBuilder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new WorkTitleBuilder();
        b.title(title);
        cl.setDelegate(b);
        cl.setResolveStrategy(Closure.DELEGATE_ONLY);
        cl.run();
        this.title = b.build();
        return this;
    }

    public WorkBuilder movements(String movements) {
        this.movements = movements;
        return this;
    }

    public Work build() {
        return new Work(title, composer, movements);
    }

}
