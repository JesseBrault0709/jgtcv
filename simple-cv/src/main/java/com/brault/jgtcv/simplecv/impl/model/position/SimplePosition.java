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

    public static class Builder implements CVNodeBuilder<SimplePosition> {

        private String institution;
        private String role;
        private DateRangeNode dateRange;
        private Duties duties;

        public Builder institution(String institution) {
            this.institution = institution;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder dateRange(DateRangeNode dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        public Builder dateRange(
                @DelegatesTo(value = SimpleDateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                        Closure<?> cl
        ) {
            this.dateRange = CVNodeBuilder.buildWithClosure(cl, SimpleDateRangeNode.Builder::new);
            return this;
        }

        public Builder duties(Duties duties) {
            this.duties = duties;
            return this;
        }

        public Builder duties(
                @DelegatesTo(value = SimpleDuties.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.duties = CVNodeBuilder.buildWithClosure(cl, SimpleDuties.Builder::new);
            return this;
        }

        @Override
        public SimplePosition build() {
            return new SimplePosition(this);
        }

    }

    private final String institution;
    private final String role;
    private final DateRangeNode dateRange;
    private final Duties duties;

    public SimplePosition(Builder builder) {
        this.institution = builder.institution;
        this.role = builder.role;
        this.dateRange = builder.dateRange;
        this.duties = builder.duties;
    }

    public Optional<Duties> getDuties() {
        return Optional.ofNullable(this.duties);
    }

}
