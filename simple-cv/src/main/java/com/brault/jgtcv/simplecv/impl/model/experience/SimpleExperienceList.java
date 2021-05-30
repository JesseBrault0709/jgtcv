package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.api.model.experience.ExperienceList;
import com.brault.jgtcv.simplecv.impl.model.section.AbstractCVSection;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import java.util.Collection;
import java.util.LinkedList;

public class SimpleExperienceList extends AbstractCVSection implements ExperienceList {

    public static class Builder extends AbstractCVSection.Builder<Builder, SimpleExperienceList> {

        private static final String DEFAULT_SECTION_NAME = "Experience";

        private final Collection<Experience> experiences = new LinkedList<>();

        public Builder() {
            this.sectionName(DEFAULT_SECTION_NAME);
        }

        public Builder experience(Experience experience) {
            this.experiences.add(experience);
            return this;
        }

        public Builder exp(
                @DelegatesTo(value = SimpleExperience.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.experiences.add(CVNodeBuilder.buildWithClosure(cl, SimpleExperience.Builder::new));
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public SimpleExperienceList build() {
            return null;
        }

    }

    private final Collection<Experience> experiences;

    public SimpleExperienceList(Builder b) {
        super(b);
        this.experiences = b.experiences;
    }

    public Collection<Experience> getExperiences() {
        return this.experiences;
    }

}
