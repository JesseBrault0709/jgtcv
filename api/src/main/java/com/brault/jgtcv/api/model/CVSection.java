package com.brault.jgtcv.api.model;

/**
 * A representation of a section of a CV.
 */
public interface CVSection extends CVNode {

    /**
     * Returns the name of the section to be used in a section header or elsewhere.
     */
    String getSectionName();

}
