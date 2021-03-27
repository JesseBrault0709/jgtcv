package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.simplecv.api.model.position.PositionList;
import com.brault.jgtcv.simplecv.api.model.position.Position;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SimplePositionListBuilder {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Positions";

    private final Collection<Position> positions = new LinkedList<>();

    public SimplePositionListBuilder position(Position position) {
        this.positions.add(position);
        return this;
    }

    public SimplePositionListBuilder position(
            @DelegatesTo(value = SimplePositionBuilder.class, strategy = Closure.DELEGATE_FIRST)
            Closure<?> cl
    ) {
        final var b = new SimplePositionBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_FIRST);
        rehydrated.run();
        this.positions.add(b.build());
        return this;
    }

    public SimplePositionListBuilder positions(Collection<? extends Position> positions) {
        this.positions.addAll(positions);
        return this;
    }

    public PositionList build() {
        return new SimplePositionList(this.sectionName, List.copyOf(this.positions));
    }

}
