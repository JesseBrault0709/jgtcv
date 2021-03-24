package com.brault.jgtcv.simplecv.model.experience;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.api.model.CVSection;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class ExperienceList implements CVSection {

    public static final String NODE_TYPE_NAME = "experiences";

    @NonNull
    String sectionName;

    @NonNull
    Collection<Experience> experiences;

}
