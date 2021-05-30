package com.brault.jgtcv.musiccv.api.model.musicalwork;

import com.brault.jgtcv.api.model.node.CVNode;
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorkTitle;

import java.util.Optional;

public interface Work extends CVNode {

    SimpleWorkTitle getTitle();
    String getComposer();
    Optional<String> getMovements();

}
