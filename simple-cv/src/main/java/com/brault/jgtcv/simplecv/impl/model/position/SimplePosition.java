package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.position.Position;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateRangeNode;
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDuties;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class SimplePosition implements Position {

    public static Builder getBuilder() { return new SimpleBuilder(); }

    private static class SimpleBuilder implements Builder {

        private String institution;
        private String role;
        private DateRangeNode dateRange;
        private Duties duties;

        @Override
        public SimpleBuilder institution(String institution) {
            this.institution = institution;
            return this;
        }

        @Override
        public String institution() {
            return this.institution;
        }

        @Override
        public SimpleBuilder role(String role) {
            this.role = role;
            return this;
        }

        @Override
        public String role() { return this.role; }

        @Override
        public SimpleBuilder dates(DateRangeNode dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        @Override
        public SimpleBuilder dates(
                @DelegatesTo(value = SimpleDateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                        Closure<?> cl
        ) {
            this.dateRange = CVNodeBuilder.buildWithClosure(cl, SimpleDateRangeNode::getBuilder);
            return this;
        }

        @Override
        public DateRangeNode dates() { return this.dateRange; }

        @Override
        public SimpleBuilder duties(Duties duties) {
            this.duties = duties;
            return this;
        }

        @Override
        public SimpleBuilder duties(
                @DelegatesTo(value = SimpleDuties.BuilderImpl.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.duties = CVNodeBuilder.buildWithClosure(cl, SimpleDuties.BuilderImpl::new);
            return this;
        }

        @Override
        public Duties duties() { return this.duties; }

        @Override
        public Position build() {
            return new SimplePosition(this);
        }

    }

    private final String institution;
    private final String role;
    private final DateRangeNode dates;
    private final Duties duties;

    public SimplePosition(Builder builder) {
        this.institution = builder.institution();
        this.role = builder.role();
        this.dates = builder.dates();
        this.duties = builder.duties();
    }

    public Optional<Duties> getDuties() {
        return Optional.ofNullable(this.duties);
    }

}
