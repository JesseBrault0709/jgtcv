package com.brault.jgtcv.musiccv.impl.model.education;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.education.Degree;
import com.brault.jgtcv.api.model.education.RelevantCoursework;
import com.brault.jgtcv.musiccv.api.model.education.MusicDegree;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeNode;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegree;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleRelevantCoursework;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class SimpleMusicDegree extends SimpleDegree implements MusicDegree {

    // Decorator pattern
    public static class Builder implements Degree.Builder {

        private final Degree.Builder simpleDegreeBuilder = SimpleDegree.getBuilder();
        private final Collection<String> privateTeachers = new LinkedList<>();

        // New methods

        public Builder privateTeacher(String privateTeacher) {
            this.privateTeachers.add(privateTeacher);
            return this;
        }

        public Builder privateTeachers(Collection<String> privateTeachers) {
            this.privateTeachers.addAll(privateTeachers);
            return this;
        }

        // Interface methods

        @Override
        public Builder institution(String institution) {
            simpleDegreeBuilder.institution(institution);
            return this;
        }

        @Override
        public String institution() { return this.simpleDegreeBuilder.institution(); }

        @Override
        public Builder dates(DateRangeNode dateRange) {
            simpleDegreeBuilder.dates(dateRange);
            return this;
        }

        @Override
        public Builder dates(
                @DelegatesTo(value = SimpleDateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            simpleDegreeBuilder.dates(cl);
            return this;
        }

        @Override
        public DateRangeNode dates() { return this.simpleDegreeBuilder.dates(); }

        @Override
        public Builder date(DateNode date) {
            simpleDegreeBuilder.date(date);
            return this;
        }

        @Override
        public Builder date(Map<String, Object> map) {
            simpleDegreeBuilder.date(map);
            return this;
        }

        @Override
        public DateNode date() { return this.simpleDegreeBuilder.date(); }

        @Override
        public Builder degreeName(String degreeName) {
            simpleDegreeBuilder.degreeName(degreeName);
            return this;
        }

        @Override
        public String degreeName() { return this.simpleDegreeBuilder.degreeName(); }

        @Override
        public Builder major(String major) {
            simpleDegreeBuilder.major(major);
            return this;
        }

        @Override
        public String major() { return this.simpleDegreeBuilder.major(); }

        @Override
        public Builder gpa(String gpa) {
            simpleDegreeBuilder.gpa(gpa);
            return this;
        }

        @Override
        public String gpa() { return this.simpleDegreeBuilder.gpa(); }

        @Override
        public Builder relevantCoursework(RelevantCoursework relevantCoursework) {
            simpleDegreeBuilder.relevantCoursework(relevantCoursework);
            return this;
        }

        @Override
        public Builder relevantCoursework(
                @DelegatesTo(value = SimpleRelevantCoursework.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            simpleDegreeBuilder.relevantCoursework(cl);
            return this;
        }

        @Override
        public RelevantCoursework relevantCoursework() { return this.simpleDegreeBuilder.relevantCoursework(); }

        @Override
        public SimpleMusicDegree build() {
            return new SimpleMusicDegree(this);
        }

    }

    @Getter
    private final Collection<String> privateTeachers;

    public SimpleMusicDegree(Builder b) {
        super(b);
        this.privateTeachers = b.privateTeachers;
    }

}
