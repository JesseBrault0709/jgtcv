package com.brault.jgtcv.simplecv.api.model.experience;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.duties.Duties;

import java.util.Optional;

public interface Experience extends CVNode {

    String getInstitution();
    DateNode getDate();
    Optional<String> getRole();
    Optional<String> getDescription();
    Optional<Duties> getDuties();

}
