package com.brault.jgtcv.simplecv.model.education;

import com.brault.jgtcv.api.model.CVNode;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class RelevantCoursework implements CVNode {

    @NonNull
    Collection<String> courses;

}
