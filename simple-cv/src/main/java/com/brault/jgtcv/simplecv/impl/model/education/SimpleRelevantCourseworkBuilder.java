package com.brault.jgtcv.simplecv.impl.model.education;

import com.brault.jgtcv.simplecv.api.model.education.RelevantCoursework;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class SimpleRelevantCourseworkBuilder {

    private final Collection<String> courses = new LinkedList<>();

    public SimpleRelevantCourseworkBuilder course(String course) {
        this.courses.add(course);
        return this;
    }

    public RelevantCoursework build() {
        return new SimpleRelevantCoursework(List.copyOf(this.courses));
    }

}
