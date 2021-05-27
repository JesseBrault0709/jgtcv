package com.brault.jgtcv.api.model.experience;

import com.brault.jgtcv.api.model.section.CVSection;

import java.util.Collection;

public interface ExperienceList extends CVSection {
    Collection<Experience> getExperiences();
}
