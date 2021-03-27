package com.brault.jgtcv.simplecv.impl.model.education;

import java.util.Collection;

import com.brault.jgtcv.simplecv.api.model.education.Education;
import com.brault.jgtcv.simplecv.api.model.education.Degree;
import lombok.NonNull;
import lombok.Value;

@Value
public class SimpleEducation implements Education {

    @NonNull
    String sectionName;

    @NonNull
    Collection<Degree> degrees;

}
