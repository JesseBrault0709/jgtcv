package com.brault.jgtcv.simplecv.impl.model.education;

import java.util.Collection;
import java.util.Optional;

import com.brault.jgtcv.api.model.ExpandoCVNode;
import com.brault.jgtcv.api.model.ExpandoCVNodeField;
import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.api.model.education.Degree;
import com.brault.jgtcv.simplecv.api.model.education.RelevantCoursework;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

/**
 * Allows extensions:
 *  Before relevantCoursework
 *  After relevantCoursework
 */
@Getter
@ToString(callSuper = true)
public class SimpleDegree extends ExpandoCVNode<SimpleDegree.ExpandoFields> implements Degree {

    public enum ExpandoFields {
        RELEVANT_COURSEWORK;
    }

    @NonNull
    private final String institution;

    @NonNull
    private final DateRange dateRange;

    @NonNull
    private final String degreeName;

    private final String major;
    private final String gpa;
    private final RelevantCoursework relevantCoursework;

    public SimpleDegree(
            String institution,
            String degreeName,
            String major,
            String gpa,
            DateRange dateRange,
            RelevantCoursework relevantCoursework,
            Collection<ExpandoCVNodeField<ExpandoFields>> extra
    ) {
        super(extra);
        this.institution = requireNonNull(institution);
        this.degreeName = requireNonNull(degreeName);
        this.major = major;
        this.gpa = gpa;
        this.dateRange = requireNonNull(dateRange);
        this.relevantCoursework = relevantCoursework;
    }

    @Override
    public Optional<String> getMajor() {
        return Optional.ofNullable(this.major);
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
