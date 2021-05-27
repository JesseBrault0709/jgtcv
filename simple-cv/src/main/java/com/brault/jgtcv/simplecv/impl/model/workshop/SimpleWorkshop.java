package com.brault.jgtcv.simplecv.impl.model.workshop;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.workshop.Workshop;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

@Getter @AllArgsConstructor
public class SimpleWorkshop implements Workshop {

    public static class Builder implements CVNodeBuilder<SimpleWorkshop> {

        private String workshopName;
        private DateNode dateNode;
        private String location;
        private final Collection<String> instructors = new LinkedList<>();

        public Builder workshopName(String workshopName) {
            this.workshopName = workshopName;
            return this;
        }

        public Builder date(DateNode dateNode) {
            this.dateNode = dateNode;
            return this;
        }

        public Builder date(Map<String, ?> map) {
            this.dateNode = SimpleDateNode.fromMap(map);
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder instructor(String instructor) {
            this.instructors.add(instructor);
            return this;
        }

        @Override
        public SimpleWorkshop build() {
            return new SimpleWorkshop(this);
        }

    }

    private final String workshopName;
    private final DateNode date;
    private final String location;
    private final Collection<String> instructors;

    public SimpleWorkshop(Builder b) {
        this.workshopName = b.workshopName;
        this.date = b.dateNode;
        this.location = b.location;
        this.instructors = b.instructors;
    }

    public Optional<String> getLocation() {
        return Optional.ofNullable(this.location);
    }

}
