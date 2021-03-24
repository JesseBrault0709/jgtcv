package com.brault.jgtcv.api.model;

import java.util.Collection;

/**
 * The main CV object.
 */
public interface CV extends CVNode {

    Collection<CVSection> getSections();
    
}
