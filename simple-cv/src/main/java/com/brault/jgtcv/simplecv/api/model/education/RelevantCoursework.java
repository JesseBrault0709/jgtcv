package com.brault.jgtcv.simplecv.api.model.education;

import com.brault.jgtcv.api.model.CVNode;

public interface RelevantCoursework extends CVNode {
    java.util.Collection<String> getCourses();
}
