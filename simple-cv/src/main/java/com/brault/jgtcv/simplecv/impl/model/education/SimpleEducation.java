package com.brault.jgtcv.simplecv.impl.model.education;

import java.util.Collection;
import java.util.LinkedList;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.education.Degree;
import com.brault.jgtcv.api.model.education.Education;
import com.brault.jgtcv.simplecv.impl.model.section.AbstractCVSection;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.*;

import static java.util.Objects.requireNonNull;

public class SimpleEducation extends AbstractCVSection implements Education {

    public static class Builder extends AbstractCVSection.Builder<Builder, SimpleEducation> {

        private static final String DEFAULT_SECTION_NAME = "Education";

        public Builder() {
            this.sectionName(DEFAULT_SECTION_NAME);
        }

        private final Collection<Degree> degrees = new LinkedList<>();

        public Builder degree(Degree degree) {
            this.degrees.add(requireNonNull(degree));
            return this.self();
        }

        public Builder degree(
            @DelegatesTo(value = Degree.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
        ) {
            this.degrees.add(CVNodeBuilder.buildWithClosure(requireNonNull(cl), SimpleDegree::getBuilder));
            return this.self();
        }

        @Override
        public SimpleEducation build() {
            return new SimpleEducation(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    @Getter
    private final Collection<Degree> degrees;

    public SimpleEducation(Builder b) {
        super(b);
        this.degrees = b.degrees;
    }

}
