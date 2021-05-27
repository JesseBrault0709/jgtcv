package com.brault.jgtcv.api.model.position;

import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Optional;

public interface Position extends CVNode {

    Optional<Duties> getDuties();
    String getInstitution();
    String getRole();
    DateRangeNode getDateRange();

}
