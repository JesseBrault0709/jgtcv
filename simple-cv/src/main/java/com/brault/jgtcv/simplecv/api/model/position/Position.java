package com.brault.jgtcv.simplecv.api.model.position;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.api.model.duties.Duties;

import java.util.Optional;

public interface Position extends CVNode {

    Optional<Duties> getDutiesList();
    String getInstitution();
    String getRole();
    DateRange getDateRange();

}
