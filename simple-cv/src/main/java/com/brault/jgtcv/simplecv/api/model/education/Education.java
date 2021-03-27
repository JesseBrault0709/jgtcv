package com.brault.jgtcv.simplecv.api.model.education;

import com.brault.jgtcv.api.model.CVSection;

import java.util.Collection;

public interface Education extends CVSection {

    Collection<Degree> getDegrees();

}
