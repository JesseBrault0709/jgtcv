package com.brault.jgtcv.simplecv.api.model.education;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateRange;

import java.util.Optional;

public interface Degree extends CVNode {

    Optional<String> getMajor();
    Optional<String> getGpa();
    Optional<RelevantCoursework> getRelevantCoursework();

    String getInstitution();
    DateRange getDateRange();
    String getDegreeName();

}
