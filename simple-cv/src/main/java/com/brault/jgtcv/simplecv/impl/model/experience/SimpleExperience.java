package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDuties;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleExperience implements Experience {

    public static Experience.Builder getBuilder() { return new BuilderImpl(); }

    private static final class BuilderImpl implements Experience.Builder {

        private String institution;
        private DateNode date;
        private String role;
        private String description;
        private Duties duties;

        @Override
        public Builder institution(String institution) { this.institution = institution; return this; }

        @Override public String institution() { return this.institution; }


        @Override
        public Builder date(DateNode date) { this.date = date; return this; }

        /**
         * @implSpec Calls Builder.date(DateNode).
         *
         * @param map
         * @return
         */
        @Override
        public Builder date(Map<String, Object> map) {
            return this.date(SimpleDateNode.fromMap(map));
        }

        @Override public DateNode date() { return this.date; }


        @Override
        public Builder role(String role) { this.role = role; return this; }

        @Override public String role() { return this.role; }


        @Override
        public Builder description(String description) { this.description = description; return this; }

        @Override public String description() { return this.description; }


        @Override
        public Builder duties(Duties duties) { this.duties = duties; return this; }

        @Override
        public Builder duties(Closure<?> cl) {
            this.duties = CVNodeBuilder.buildWithClosure(cl, SimpleDuties.BuilderImpl::new);
            return this;
        }

        @Override public Duties duties() { return this.duties; }


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

    public SimpleExperience(Experience.Builder b) {
        this.institution = b.institution();
        this.date = b.date();
        this.role = b.role();
        this.description = b.description();
        this.duties = b.duties();
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
