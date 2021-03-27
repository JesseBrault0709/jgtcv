package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.model.CVSection;
import com.brault.jgtcv.simplecv.api.model.experience.Experience;
import com.brault.jgtcv.simplecv.api.model.experience.ExperienceList;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class SimpleExperienceList implements ExperienceList {

    public static final String NODE_TYPE_NAME = "experiences";

    @NonNull
    String sectionName;

    @NonNull
    Collection<Experience> experiences;

}
