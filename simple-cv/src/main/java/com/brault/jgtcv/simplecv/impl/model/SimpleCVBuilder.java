package com.brault.jgtcv.simplecv.impl.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.model.section.CVSection;
import com.google.auto.service.AutoService;

import static java.util.Objects.requireNonNull;

@AutoService(CVBuilder.class)
public final class SimpleCVBuilder implements CVBuilder {

    private final Collection<CVSection> sections = new LinkedList<>();

    @Override
    public CVBuilder section(CVSection section) {
        this.sections.add(requireNonNull(section));
        return this;
    }

    @Override
    public CVBuilder sections(Collection<? extends CVSection> sections) {
        this.sections.addAll(requireNonNull(sections));
        return this;
    }
    
    @Override
    public CV build() {
        return new SimpleCV(List.copyOf(this.sections));
    }

    
}
