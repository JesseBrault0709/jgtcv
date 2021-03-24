package com.brault.jgtcv.simplecv.model.education;

import java.util.Collection;
import java.util.LinkedList;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public final class EducationBuilder {
    
    private final Collection<Degree> degrees = new LinkedList<>();

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Education";

    public EducationBuilder degree(
            @DelegatesTo(value = DegreeBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new DegreeBuilder();

        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();

        this.degrees.add(b.build());
        return this;
    }

    public Education build() {
        return new Education(sectionName, degrees);
    }

}
