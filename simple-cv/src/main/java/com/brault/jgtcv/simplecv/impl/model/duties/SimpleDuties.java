package com.brault.jgtcv.simplecv.impl.model.duties;

import com.brault.jgtcv.api.model.duties.Duties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class SimpleDuties implements Duties {

    public static Duties.Builder getBuilder() { return new BuilderImpl(); }

    public static class BuilderImpl implements Duties.Builder {

        private final Collection<String> duties = new LinkedList<>();
        private boolean presentTense = false; // default

        @Override
        public BuilderImpl duty(String duty) {
            this.duties.add(requireNonNull(duty));
            return this;
        }

        @Override
        public Duties.Builder duties(Collection<String> duties) {
            this.duties.addAll(requireNonNull(duties));
            return this;
        }

        @Override
        public Collection<String> duties() {
            return List.copyOf(this.duties);
        }

        @Override
        public BuilderImpl presentTense(boolean presentTense) {
            this.presentTense = presentTense;
            return this;
        }

        @Override
        public boolean presentTense() { return this.presentTense; }

        @Override
        public SimpleDuties build() {
            return new SimpleDuties(this);
        }

    }

    @Getter
    private final Collection<String> duties;

    @Getter
    private final boolean presentTense;

    public SimpleDuties(Duties.Builder b) {
        this.duties = b.duties();
        this.presentTense = b.presentTense();
    }

}
