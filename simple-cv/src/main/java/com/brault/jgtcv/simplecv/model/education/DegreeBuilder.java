package com.brault.jgtcv.simplecv.model.education;

import com.brault.jgtcv.api.model.ExpandoCVNodeBuilder;
import com.brault.jgtcv.simplecv.model.date.DateRange;
import com.brault.jgtcv.simplecv.model.date.DateRangeBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class DegreeBuilder extends ExpandoCVNodeBuilder<Degree, Degree.ExpandoFields> {

    private String institution;
    private String degreeName;
    private String major;
    private String gpa;

    private DateRange dateRange;

    private RelevantCoursework relevantCoursework;

    public DegreeBuilder institution(String institution) {
        this.institution = institution;
        return this;
    }

    public DegreeBuilder degreeName(String degreeName) {
        this.degreeName = degreeName;
        return this;
    }

    public DegreeBuilder major(String major) {
        this.major = major;
        return this;
    }

    public DegreeBuilder gpa(String gpa) {
        this.gpa = gpa;
        return this;
    }

    public DegreeBuilder dates(
            @DelegatesTo(value = DateRangeBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new DateRangeBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.dateRange = b.build();
        return this;
    }

    public DegreeBuilder relevantCoursework(
            @DelegatesTo(value = RelevantCourseworkBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new RelevantCourseworkBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.relevantCoursework = b.build();
        return this;
    }

    @Override
    public Degree build() {
        return new Degree(
                this.institution,
                this.degreeName,
                this.major,
                this.gpa,
                this.dateRange,
                this.relevantCoursework,
                this.getExtra()
        );
    }

}
