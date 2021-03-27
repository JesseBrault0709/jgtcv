package com.brault.jgtcv.simplecv.model.position;

import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class PositionBuilder {

    private String institution;
    private String role;

    private DateRange dateRange;

    private Duties duties;

    public PositionBuilder institution(String institution) {
        this.institution = institution;
        return this;
    }

    public PositionBuilder role(String role) {
        this.role = role;
        return this;
    }

    public PositionBuilder dates(
            @DelegatesTo(value = SimpleDateRangeBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new SimpleDateRangeBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.dateRange = b.build();
        return this;
    }

    public PositionBuilder duties(
            @DelegatesTo(value = DutiesBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new DutiesBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.duties = b.build();
        return this;
    }

    public Position build() {
        return new Position(
                this.institution,
                this.role,
                this.dateRange,
                this.duties
        );
    }

}
