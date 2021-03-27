package com.brault.jgtcv.simplecv.api.model.heading;

import com.brault.jgtcv.api.model.CVSection;

import java.util.Optional;

public interface CVHeading extends CVSection {

    Optional<String> getDocumentTitle();
    String getName();
    String getProfessionalTitle();

}
