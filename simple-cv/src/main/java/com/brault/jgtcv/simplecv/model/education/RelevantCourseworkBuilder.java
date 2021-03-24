package com.brault.jgtcv.simplecv.model.education;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class RelevantCourseworkBuilder {

    private final Collection<String> courses = new LinkedList<>();

    public RelevantCourseworkBuilder course(String course) {
        this.courses.add(course);
        return this;
    }

    public RelevantCoursework build() {
        return new RelevantCoursework(List.copyOf(this.courses));
    }

}
