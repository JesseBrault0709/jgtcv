package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.position.Position;
import com.brault.jgtcv.api.model.position.PositionList;
import com.brault.jgtcv.simplecv.impl.model.section.AbstractCVSection;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

public class SimplePositionList extends AbstractCVSection implements PositionList {

    public static class Builder extends AbstractCVSection.Builder<Builder, SimplePositionList> {

        private final Collection<Position> positions = new LinkedList<>();

        public Builder position(Position position) {
            this.positions.add(position);
            return this.self();
        }

        public Builder position(
                @DelegatesTo(value = SimplePosition.Builder.class, strategy = Closure.DELEGATE_ONLY)
                        Closure<?> cl
        ) {
            this.position(CVNodeBuilder.buildWithClosure(cl, SimplePosition::getBuilder));
            return this.self();
        }

        @Override
        public SimplePositionList build() {
            return new SimplePositionList(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    @Getter
    private final Collection<Position> positions;

    public SimplePositionList(Builder builder) {
        super(builder);
        this.positions = builder.positions;
    }

}
