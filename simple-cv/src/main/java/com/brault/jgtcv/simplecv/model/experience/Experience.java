package com.brault.jgtcv.simplecv.model.experience;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.model.date.DateNode;

import java.util.Optional;

public interface Experience extends CVNode {

    String getInstitution();
    DateNode getDate();
    Optional<String> getRole();
    Optional<String> getDescription();

}
