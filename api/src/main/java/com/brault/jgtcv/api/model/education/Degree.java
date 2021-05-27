package com.brault.jgtcv.api.model.education;

import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Optional;

public interface Degree extends CVNode {

    String getInstitution();

    Optional<DateRangeNode> getDateRange();
    Optional<DateNode> getDate();
    Optional<String> getDegreeName();

    Optional<String> getMajor();
    Optional<String> getGpa();
    Optional<RelevantCoursework> getRelevantCoursework();

}
