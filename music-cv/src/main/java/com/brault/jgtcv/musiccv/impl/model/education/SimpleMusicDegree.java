package com.brault.jgtcv.musiccv.impl.model.education;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.education.RelevantCoursework;
import com.brault.jgtcv.musiccv.api.model.education.MusicDegree;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegree;
import groovy.lang.Closure;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class SimpleMusicDegree extends SimpleDegree implements MusicDegree {

    // Decorator pattern ish
    public static class Builder implements CVNodeBuilder<SimpleMusicDegree> {

        private final SimpleDegree.Builder simpleDegreeBuilder = new SimpleDegree.Builder();
        private final Collection<String> privateTeachers = new LinkedList<>();

        public Builder privateTeacher(String privateTeacher) {
            this.privateTeachers.add(privateTeacher);
            return this;
        }

        public Builder privateTeachers(Collection<String> privateTeachers) {
            this.privateTeachers.addAll(privateTeachers);
            return this;
        }

        public Builder institution(String institution) {
            simpleDegreeBuilder.institution(institution);
            return this;
        }

        public Builder dates(DateRangeNode dateRange) {
            simpleDegreeBuilder.dates(dateRange);
            return this;
        }

        public Builder dates(Closure<?> cl) {
            simpleDegreeBuilder.dates(cl);
            return this;
        }

        public Builder date(DateNode date) {
            simpleDegreeBuilder.date(date);
            return this;
        }

        public Builder date(Map<String, Object> map) {
            simpleDegreeBuilder.date(map);
            return this;
        }

        public Builder degreeName(String degreeName) {
            simpleDegreeBuilder.degreeName(degreeName);
            return this;
        }

        public Builder major(String major) {
            simpleDegreeBuilder.major(major);
            return this;
        }

        public Builder gpa(String gpa) {
            simpleDegreeBuilder.gpa(gpa);
            return this;
        }

        public Builder relevantCoursework(RelevantCoursework relevantCoursework) {
            simpleDegreeBuilder.relevantCoursework(relevantCoursework);
            return this;
        }

        public Builder relevantCoursework(Closure<?> cl) {
            simpleDegreeBuilder.relevantCoursework(cl);
            return this;
        }

        @Override
        public SimpleMusicDegree build() {
            return new SimpleMusicDegree(this);
        }

    }

    @Getter
    private final Collection<String> privateTeachers;

    public SimpleMusicDegree(Builder b) {
        super(b.simpleDegreeBuilder);
        this.privateTeachers = b.privateTeachers;
    }

}
