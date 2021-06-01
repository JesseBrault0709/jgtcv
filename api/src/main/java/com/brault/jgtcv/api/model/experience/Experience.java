package com.brault.jgtcv.api.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.node.CVNode;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import java.util.Map;
import java.util.Optional;

public interface Experience extends CVNode {

    interface Builder extends CVNodeBuilder<Experience> {
        Builder institution(String institution);
        String institution();

        Builder date(DateNode date);
        Builder date(Map<String, Object> dateMap);
        DateNode date();

        Builder role(String role);
        String role();

        Builder description(String description);
        String description();

        Builder duties(Duties duties);
        Builder duties(
                @DelegatesTo(value = Duties.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        );
        Duties duties();
    }

    abstract class ForwardingBuilder implements Builder {

        private final Builder b;

        public ForwardingBuilder(Builder b) { this.b = b; }

        @Override
        public Builder institution(String institution) {
            return b.institution(institution);
        }

        @Override
        public String institution() {
            return b.institution();
        }

        @Override
        public Builder date(DateNode date) {
            return b.date(date);
        }

        @Override
        public Builder date(Map<String, Object> dateMap) {
            return b.date(dateMap);
        }

        @Override
        public DateNode date() {
            return b.date();
        }

        @Override
        public Builder role(String role) {
            return b.role(role);
        }

        @Override
        public String role() {
            return b.role();
        }

        @Override
        public Builder description(String description) {
            return b.description(description);
        }

        @Override
        public String description() {
            return b.description();
        }

        @Override
        public Builder duties(Duties duties) {
            return b.duties(duties);
        }

        @Override
        public Builder duties(Closure<?> cl) {
            return b.duties(cl);
        }

        @Override
        public Duties duties() {
            return b.duties();
        }

    }

    String getInstitution();
    DateNode getDate();

    Optional<String> getRole();
    Optional<String> getDescription();
    Optional<Duties> getDuties();

}
