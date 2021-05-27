package com.brault.jgtcv.simplecv.impl.model.duties;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.duties.Duties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

@AllArgsConstructor
public class SimpleDuties implements Duties {

    public static class Builder implements CVNodeBuilder<SimpleDuties> {

        private final Collection<String> duties = new LinkedList<>();
        private boolean presentTense = false; // default

        public Builder duty(String duty) {
            this.duties.add(duty);
            return this;
        }

        public Builder presentTense(boolean presentTense) {
            this.presentTense = presentTense;
            return this;
        }

        @Override
        public SimpleDuties build() {
            return new SimpleDuties(this);
        }

    }

    @Getter
    private final Collection<String> duties;

    @Getter
    private final boolean presentTense;

    public SimpleDuties(Builder b) {
        this.duties = b.duties;
        this.presentTense = b.presentTense;
    }

}
