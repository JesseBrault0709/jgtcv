package com.brault.jgtcv.simplecv.api.model.experience;

import com.brault.jgtcv.api.model.CVSection;

public interface ExperienceList extends CVSection {
    java.util.Collection<com.brault.jgtcv.simplecv.api.model.experience.Experience> getExperiences();
}
