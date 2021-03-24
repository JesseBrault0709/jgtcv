package com.brault.jgtcv.simplecv.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.model.CVSection;
import com.brault.jgtcv.simplecv.model.heading.CVHeadingBuilder;
import com.google.auto.service.AutoService;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

@AutoService(CVBuilder.class)
public final class CVBuilderImpl implements CVBuilder {

    private final Collection<CVSection> sections = new LinkedList<>();

    @Override
    public CVBuilder section(CVSection section) {
        this.sections.add(section);
        return this;
    }

    @Override
    public CVBuilder sections(Collection<? extends CVSection> sections) {
        this.sections.addAll(sections);
        return this;
    }
    
    @Override
    public CV build() {
        return new CVImpl(List.copyOf(this.sections));
    }

    
}
