package com.brault.jgtcv.simplecv.impl.model;

import java.util.Collection;
import java.util.LinkedList;

import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.model.section.CVSection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class SimpleCV implements CV {

    public static final String NODE_NAME = "cv";

    private final Collection<CVSection> sections = new LinkedList<>();

    public SimpleCV(Collection<? extends CVSection> sections) {
        this.sections.addAll(sections);
    }

}
