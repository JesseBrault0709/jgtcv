package com.brault.jgtcv.simplecv.model.heading;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.api.model.CVSection;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Value
public class CVHeading implements CVSection {

    @NonNull
    String name;

    @NonNull
    String professionalTitle;

    String documentTitle;

    public Optional<String> getDocumentTitle() {
        return Optional.ofNullable(this.documentTitle);
    }

    @Override
    public String getSectionName() {
        return null;
    }

}
