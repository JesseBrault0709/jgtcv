package com.brault.jgtcv.musiccv.api.model.musicalwork;

import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Collection;

public interface WorksList extends CVNode {

    Collection<Work> getWorks();

}
