package com.brault.jgtcv.simplecv.impl.model.education;

import java.util.Map;
import java.util.Optional;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.education.Degree;
import com.brault.jgtcv.api.model.education.RelevantCoursework;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeNode;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.*;

import static java.util.Objects.requireNonNull;

/**
 * Allows extensions:
 *  Before relevantCoursework
 *  After relevantCoursework
 */
@AllArgsConstructor
public class SimpleDegree implements Degree {

    public static class Builder implements CVNodeBuilder<SimpleDegree> {

        private String institution;
        private DateRangeNode dateRange;
        private DateNode date;
        private String degreeName;
        private String major;
        private String gpa;
        private RelevantCoursework relevantCoursework;

        public Builder institution(String institution) {
            this.institution = institution;
            return this;
        }

        public Builder dates(DateRangeNode dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        public Builder dates(
                @DelegatesTo(value = SimpleDateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.dateRange = CVNodeBuilder.buildWithClosure(cl, SimpleDateRangeNode.Builder::new);
            return this;
        }

        public Builder date(DateNode date) {
            this.date = date;
            return this;
        }

        public Builder date(Map<String, Object> map) {
            this.date = SimpleDateNode.fromMap(map);
            return this;
        }

        public Builder degreeName(String degreeName) {
            this.degreeName = degreeName;
            return this;
        }

        public Builder major(String major) {
            this.major = major;
            return this;
        }

        public Builder gpa(String gpa) {
            this.gpa = gpa;
            return this;
        }

        public Builder relevantCoursework(RelevantCoursework relevantCoursework) {
            this.relevantCoursework = relevantCoursework;
            return this;
        }

        public Builder relevantCoursework(
                @DelegatesTo(value = SimpleRelevantCoursework.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.relevantCoursework = CVNodeBuilder.buildWithClosure(cl, SimpleRelevantCoursework.Builder::new);
            return this;
        }

        @Override
        public SimpleDegree build() {
            return new SimpleDegree(this);
        }

    }

    private final String institution;
    private final DateRangeNode dateRange;
    private final DateNode date;

    private final String degreeName;
    private final String major;
    private final String gpa;
    private final RelevantCoursework relevantCoursework;

    public SimpleDegree(Builder b) {
        this.institution = b.institution;
        this.dateRange = b.dateRange;
        this.date = b.date;

        this.degreeName = b.degreeName;
        this.major = b.major;
        this.gpa = b.gpa;
        this.relevantCoursework = b.relevantCoursework;
    }

    @Override
    public String getInstitution() {
        return this.institution;
    }

    @Override
    public Optional<DateRangeNode> getDateRange() {
        return Optional.ofNullable(this.dateRange);
    }

    @Override
    public Optional<DateNode> getDate() {
        return Optional.ofNullable(this.date);
    }

    @Override
    public Optional<String> getDegreeName() {
        return Optional.ofNullable(this.degreeName);
    }

    @Override
    public Optional<String> getMajor() {
        return Optional.of(this.major);
    }

    @Override
    public Optional<String> getGpa() {
        return Optional.ofNullable(this.gpa);
    }

    @Override
    public Optional<RelevantCoursework> getRelevantCoursework() {
        return Optional.ofNullable(this.relevantCoursework);
    }

}
