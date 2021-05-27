package com.brault.jgtcv.api.model.education;

import com.brault.jgtcv.api.model.node.CVNode;

public interface RelevantCoursework extends CVNode {
    java.util.Collection<String> getCourses();
}
