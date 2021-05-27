package com.brault.jgtcv.api.model.workshop;

import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Collection;
import java.util.Optional;

public interface Workshop extends CVNode {

    String getWorkshopName();
    DateNode getDate();
    Optional<String> getLocation();
    Collection<String> getInstructors();

}
