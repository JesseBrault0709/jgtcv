package com.brault.jgtcv.simplecv.impl.model.heading;

import com.brault.jgtcv.simplecv.api.model.heading.CVHeading;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class SimpleCVHeading implements CVHeading {

    @NonNull
    String name;

    @NonNull
    String professionalTitle;

    String documentTitle;

    @Override
    public Optional<String> getDocumentTitle() {
        return Optional.ofNullable(this.documentTitle);
    }

    @Override
    public String getSectionName() {
        return null;
    }

}
