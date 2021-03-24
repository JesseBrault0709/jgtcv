package com.brault.jgtcv.simplecv.model.position;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PositionListBuilder {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Positions";

    private final Collection<Position> positions = new LinkedList<>();

    public PositionListBuilder position(Position position) {
        this.positions.add(position);
        return this;
    }

    public PositionListBuilder position(
            @DelegatesTo(value = PositionBuilder.class, strategy = Closure.DELEGATE_FIRST)
            Closure<?> cl
    ) {
        final var b = new PositionBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.positions.add(b.build());
        return this;
    }

    public PositionListBuilder positions(Collection<? extends Position> positions) {
        this.positions.addAll(positions);
        return this;
    }

    public PositionList build() {
        return new PositionList(this.sectionName, List.copyOf(this.positions));
    }

}
