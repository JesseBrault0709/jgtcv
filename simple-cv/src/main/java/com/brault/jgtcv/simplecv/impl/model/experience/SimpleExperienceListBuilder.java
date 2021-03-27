package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.simplecv.api.model.experience.Experience;
import com.brault.jgtcv.simplecv.api.model.experience.ExperienceList;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SimpleExperienceListBuilder {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Experience";

    private final Collection<Experience> experiences = new LinkedList<>();

    public SimpleExperienceListBuilder exp(Experience exp) {
        this.experiences.add(exp);
        return this;
    }

    public SimpleExperienceListBuilder exp(
            @DelegatesTo(value = SimpleExperienceBuilder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new SimpleExperienceBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        this.experiences.add(b.build());
        return this;
    }

    public ExperienceList build() {
        return new SimpleExperienceList(this.sectionName, List.copyOf(this.experiences));
    }

}
