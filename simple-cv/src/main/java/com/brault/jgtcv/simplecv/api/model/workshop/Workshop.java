package com.brault.jgtcv.simplecv.api.model.workshop;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;

import java.util.Collection;
import java.util.Optional;

public interface Workshop extends CVNode {

    String getWorkshopName();
    DateNode getDate();
    Optional<String> getLocation();
    Collection<String> getInstructors();

}
