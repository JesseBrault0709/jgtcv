package com.brault.jgtcv.musiccv.api.model.musicalwork;

import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Optional;

public interface Work extends CVNode {

    WorkTitle getTitle();
    String getComposer();
    Optional<String> getMovements();

}
