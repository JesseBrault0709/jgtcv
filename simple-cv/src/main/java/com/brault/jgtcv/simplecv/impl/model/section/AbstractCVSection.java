package com.brault.jgtcv.simplecv.impl.model.section;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.section.CVSection;
import lombok.Getter;

public abstract class AbstractCVSection implements CVSection {

    public static abstract class Builder<B extends Builder<B, T>, T extends AbstractCVSection>
            implements CVNodeBuilder<T> {

        private String sectionName;

        public final B sectionName(String sectionName) {
            this.sectionName = sectionName;
            return this.self();
        }

        public final String sectionName() {
            return this.sectionName;
        }

        abstract protected B self();

    }

    @Getter
    private final String sectionName;

    public AbstractCVSection(Builder<? extends Builder<?, ?>, ? extends AbstractCVSection> builder) {
        this.sectionName = builder.sectionName;
    }

    public AbstractCVSection(String sectionName) {
        this.sectionName = sectionName;
    }

}
