package com.brault.jgtcv.simplecv.impl.model.education;

import java.util.Collection;
import java.util.LinkedList;

import com.brault.jgtcv.simplecv.api.model.education.Education;
import com.brault.jgtcv.simplecv.api.model.education.Degree;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public final class SimpleEducationBuilder {
    
    private final Collection<Degree> degrees = new LinkedList<>();

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Education";

    public SimpleEducationBuilder degree(
            @DelegatesTo(value = SimpleDegreeBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new SimpleDegreeBuilder();

        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();

        this.degrees.add(b.build());
        return this;
    }

    public Education build() {
        return new SimpleEducation(sectionName, degrees);
    }

}
