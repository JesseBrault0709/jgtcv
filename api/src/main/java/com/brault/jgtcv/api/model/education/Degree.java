package com.brault.jgtcv.api.model.education;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.node.CVNode;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import java.util.Map;
import java.util.Optional;

public interface Degree extends CVNode {

    interface Builder extends CVNodeBuilder<Degree> {
        Builder institution(String institution);
        String institution();

        Builder dates(DateRangeNode dates);
        Builder dates(
                @DelegatesTo(value = DateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        );
        DateRangeNode dates();

        Builder date(DateNode date);
        Builder date(Map<String, Object> map);
        DateNode date();

        Builder degreeName(String degreeName);
        String degreeName();

        Builder major(String major);
        String major();

        Builder gpa(String gpa);
        String gpa();

        Builder relevantCoursework(RelevantCoursework relevantCoursework);
        Builder relevantCoursework(Closure<?> cl);
        RelevantCoursework relevantCoursework();
    }

    String getInstitution();

    Optional<DateRangeNode> getDateRange();
    Optional<DateNode> getDate();
    Optional<String> getDegreeName();

    Optional<String> getMajor();
    Optional<String> getGpa();
    Optional<RelevantCoursework> getRelevantCoursework();

}
