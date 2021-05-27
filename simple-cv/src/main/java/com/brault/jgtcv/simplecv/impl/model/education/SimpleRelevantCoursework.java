package com.brault.jgtcv.simplecv.impl.model.education;


import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.education.RelevantCoursework;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

@AllArgsConstructor
public class SimpleRelevantCoursework implements RelevantCoursework {

    public static class Builder implements CVNodeBuilder<SimpleRelevantCoursework> {

        private final Collection<String> courses = new LinkedList<>();

        public Builder course(String course) {
            this.courses.add(course);
            return this;
        }

        @Override
        public SimpleRelevantCoursework build() {
            return new SimpleRelevantCoursework(this);
        }

    }

    @Getter
    private final Collection<String> courses;

    public SimpleRelevantCoursework(Builder b) {
        this.courses = b.courses;
    }

}
