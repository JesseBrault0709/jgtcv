package com.brault.jgtcv.api.model.workshop;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.node.CVNode;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface Workshop extends CVNode {

    interface Builder extends CVNodeBuilder<Workshop> {
        Builder workshopName(String workshopName);
        String workshopName();

        Builder date(DateNode date);
        Builder date(Map<String, Object> map);
        DateNode date();

        Builder location(String location);
        String location();

        Builder instructor(String instructor);
        Builder instructors(Collection<String> instructors);
        Collection<String> instructors();
    }

    abstract class ForwardingBuilder implements Builder {

        private final Builder b;

        public ForwardingBuilder(Builder b) { this.b = b; }

        @Override
        public Builder workshopName(String workshopName) {
            return b.workshopName(workshopName);
        }

        @Override
        public String workshopName() {
            return b.workshopName();
        }

        @Override
        public Builder date(DateNode date) {
            return b.date(date);
        }

        @Override
        public Builder date(Map<String, Object> map) {
            return b.date(map);
        }

        @Override
        public DateNode date() {
            return b.date();
        }

        @Override
        public Builder location(String location) {
            return b.location(location);
        }

        @Override
        public String location() {
            return b.location();
        }

        @Override
        public Builder instructor(String instructor) {
            return b.instructor(instructor);
        }

        @Override
        public Builder instructors(Collection<String> instructors) {
            return b.instructors(instructors);
        }

        @Override
        public Collection<String> instructors() {
            return b.instructors();
        }

    }

    String getWorkshopName();
    DateNode getDate();
    Optional<String> getLocation();
    Collection<String> getInstructors();

}
