package com.brault.jgtcv.simplecv.model.heading;

import java.util.Optional;

public final class CVHeadingBuilder {

    private String name;
    private String professionalTitle;
    private String documentTitle;

    public CVHeadingBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CVHeadingBuilder professionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
        return this;
    }

    public CVHeadingBuilder documentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
        return this;
    }

    public CVHeading build() {
        return new CVHeading(name, professionalTitle, documentTitle);
    }
    
}
