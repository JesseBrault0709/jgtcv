package com.brault.jgtcv.api.model;

import com.brault.jgtcv.api.model.node.CVNode;
import com.brault.jgtcv.api.model.section.CVSection;

import java.util.Collection;

/**
 * The main CV object.
 */
public interface CV extends CVNode {

    Collection<CVSection> getSections();
    
}
