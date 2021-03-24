package com.brault.jgtcv.simplecv.model.education;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.brault.jgtcv.api.model.ExpandoCVNode;
import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.api.model.ExpandoCVNodeField;
import com.brault.jgtcv.simplecv.model.date.DateRange;
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
public class Degree extends ExpandoCVNode<Degree.ExpandoFields> {

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

    public Degree(
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

    public Optional<String> getMajor() {
        return Optional.ofNullable(this.major);
    }

    public Optional<String> getGpa() {
        return Optional.ofNullable(this.gpa);
    }

    public Optional<RelevantCoursework> getRelevantCoursework() {
        return Optional.ofNullable(this.relevantCoursework);
    }

}
