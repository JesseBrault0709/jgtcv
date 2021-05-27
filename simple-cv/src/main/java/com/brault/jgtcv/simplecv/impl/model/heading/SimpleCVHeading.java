package com.brault.jgtcv.simplecv.impl.model.heading;

import com.brault.jgtcv.api.model.heading.CVHeading;
import com.brault.jgtcv.simplecv.impl.model.section.AbstractCVSection;
import lombok.Getter;

import java.util.Optional;

@Getter
public class SimpleCVHeading extends AbstractCVSection implements CVHeading {

    public static class Builder extends AbstractCVSection.Builder<Builder, SimpleCVHeading> {

        private String name;
        private String professionalTitle;
        private String documentTitle;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this.self();
        }

        public Builder professionalTitle(String professionalTitle) {
            this.professionalTitle = professionalTitle;
            return this.self();
        }

        public Builder documentTitle(String documentTitle) {
            this.documentTitle = documentTitle;
            return this.self();
        }

        @Override
        public SimpleCVHeading build() {
            return new SimpleCVHeading(this);
        }

    }

    private final String name;
    private final String professionalTitle;
    private final String documentTitle;

    public SimpleCVHeading(Builder b) {
        super(b);
        this.name = b.name;
        this.professionalTitle = b.professionalTitle;
        this.documentTitle = b.documentTitle;
    }

    @Override
    public Optional<String> getDocumentTitle() {
        return Optional.ofNullable(this.documentTitle);
    }

}
