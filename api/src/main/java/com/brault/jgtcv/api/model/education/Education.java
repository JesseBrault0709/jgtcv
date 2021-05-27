package com.brault.jgtcv.api.model.education;

import com.brault.jgtcv.api.model.section.CVSection;

import java.util.Collection;

public interface Education extends CVSection {

    Collection<Degree> getDegrees();

}
