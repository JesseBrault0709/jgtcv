package com.brault.jgtcv.api.model.experience;

import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Optional;

public interface Experience extends CVNode {

    String getInstitution();
    DateNode getDate();

    Optional<String> getRole();
    Optional<String> getDescription();
    Optional<Duties> getDuties();

}
