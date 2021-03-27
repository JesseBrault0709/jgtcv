package com.brault.jgtcv.simplecv.impl.model.heading;

import com.brault.jgtcv.simplecv.api.model.heading.CVHeading;

public final class SimpleCVHeadingBuilder {

    private String name;
    private String professionalTitle;
    private String documentTitle;

    public SimpleCVHeadingBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SimpleCVHeadingBuilder professionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
        return this;
    }

    public SimpleCVHeadingBuilder documentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
        return this;
    }

    public CVHeading build() {
        return new SimpleCVHeading(name, professionalTitle, documentTitle);
    }
    
}
