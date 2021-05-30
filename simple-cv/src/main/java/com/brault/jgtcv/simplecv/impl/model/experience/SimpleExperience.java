package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDuties;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegree;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleExperience implements Experience {

    public static class Builder implements CVNodeBuilder<SimpleExperience> {

        private String institution;
        private DateNode date;
        private String role;
        private String description;
        private Duties duties;

        public Builder institution(String institution) {
            this.institution = institution;
            return this;
        }

        public Builder date(DateNode date) {
            this.date = date;
            return this;
        }

        /**
         * @implSpec Calls Builder.date(DateNode).
         *
         * @param map
         * @return
         */
        public Builder date(Map<String, ?> map) {
            return this.date(SimpleDateNode.fromMap(map));
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
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
        public SimpleExperience build() {
            return new SimpleExperience(this);
        }

    }

    private final String institution;
    private final DateNode date;
    private final String role;
    private final String description;
    private final Duties duties;

    public SimpleExperience(Builder b) {
        this.institution = b.institution;
        this.date = b.date;
        this.role = b.role;
        this.description = b.description;
        this.duties = b.duties;
    }


    public String getInstitution() {
        return this.institution;
    }

    public DateNode getDate() {
        return this.date;
    }

    public Optional<String> getRole() {
        return Optional.ofNullable(this.role);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

    public Optional<Duties> getDuties() { return Optional.ofNullable(this.duties); }


}
