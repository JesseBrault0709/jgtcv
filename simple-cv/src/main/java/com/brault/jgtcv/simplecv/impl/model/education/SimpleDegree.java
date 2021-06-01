package com.brault.jgtcv.simplecv.impl.model.education;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.education.Degree;
import com.brault.jgtcv.api.model.education.RelevantCoursework;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeNode;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;

import static java.util.Objects.requireNonNull;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleDegree implements Degree {

    public static Degree.Builder getBuilder() { return new BuilderImpl(); }

    private static final class BuilderImpl implements Degree.Builder {

        private String institution;
        private DateRangeNode dateRange;
        private DateNode date;
        private String degreeName;
        private String major;
        private String gpa;
        private RelevantCoursework relevantCoursework;

        @Override
        public BuilderImpl institution(String institution) {
            this.institution = requireNonNull(institution);
            return this;
        }

        @Override
        public String institution() { return this.institution; }

        @Override
        public BuilderImpl dates(DateRangeNode dateRange) {
            this.dateRange = requireNonNull(dateRange);
            return this;
        }

        @Override
        public BuilderImpl dates(Closure<?> cl) {
            this.dateRange = CVNodeBuilder.buildWithClosure(requireNonNull(cl), SimpleDateRangeNode::getBuilder);
            return this;
        }

        @Override
        public DateRangeNode dates() { return this.dateRange; }

        @Override
        public BuilderImpl date(DateNode date) {
            this.date = requireNonNull(date);
            return this;
        }

        @Override
        public BuilderImpl date(Map<String, Object> map) {
            this.date = SimpleDateNode.fromMap(requireNonNull(map));
            return this;
        }

        @Override
        public DateNode date() { return this.date; }

        @Override
        public BuilderImpl degreeName(String degreeName) {
            this.degreeName = requireNonNull(degreeName);
            return this;
        }

        @Override
        public String degreeName() { return this.degreeName; }

        @Override
        public BuilderImpl major(String major) {
            this.major = requireNonNull(major);
            return this;
        }

        @Override
        public String major() { return this.major; }

        @Override
        public BuilderImpl gpa(String gpa) {
            this.gpa = requireNonNull(gpa);
            return this;
        }

        @Override public String gpa() { return this.gpa; }

        @Override
        public BuilderImpl relevantCoursework(RelevantCoursework relevantCoursework) {
            this.relevantCoursework = requireNonNull(relevantCoursework);
            return this;
        }

        @Override
        public BuilderImpl relevantCoursework(
                @DelegatesTo(value = SimpleRelevantCoursework.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.relevantCoursework = CVNodeBuilder.buildWithClosure(requireNonNull(cl), SimpleRelevantCoursework.Builder::new);
            return this;
        }

        @Override public RelevantCoursework relevantCoursework() { return this.relevantCoursework; }

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

    public SimpleDegree(Degree.Builder b) {
        this.institution = b.institution();
        this.dateRange = b.dates();
        this.date = b.date();

        this.degreeName = b.degreeName();
        this.major = b.major();
        this.gpa = b.gpa();
        this.relevantCoursework = b.relevantCoursework();
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
