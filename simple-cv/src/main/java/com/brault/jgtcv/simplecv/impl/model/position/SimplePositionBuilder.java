package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.simplecv.api.model.date.DateRange;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeBuilder;
import com.brault.jgtcv.simplecv.api.model.position.Position;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class SimplePositionBuilder {

    private String institution;
    private String role;

    private DateRange dateRange;

    private SimpleDuties duties;

    public SimplePositionBuilder institution(String institution) {
        this.institution = institution;
        return this;
    }

    public SimplePositionBuilder role(String role) {
        this.role = role;
        return this;
    }

    public SimplePositionBuilder dates(
            @DelegatesTo(value = SimpleDateRangeBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new SimpleDateRangeBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.dateRange = b.build();
        return this;
    }

    public SimplePositionBuilder duties(
            @DelegatesTo(value = SimpleDutiesBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new SimpleDutiesBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.duties = b.build();
        return this;
    }

    public Position build() {
        return new SimplePosition(
                this.institution,
                this.role,
                this.dateRange,
                this.duties
        );
    }

}
