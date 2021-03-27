package com.brault.jgtcv.simplecv.impl.model.education;

import com.brault.jgtcv.simplecv.api.model.education.RelevantCoursework;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class SimpleRelevantCoursework implements RelevantCoursework {

    @NonNull
    Collection<String> courses;

}
