package com.brault.jgtcv.simplecv.impl.model.workshop;

import com.brault.jgtcv.api.model.ExpandoCVNode;
import com.brault.jgtcv.api.model.ExpandoCVNodeField;
import com.brault.jgtcv.simplecv.api.model.workshop.Workshop;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Getter
public class SimpleWorkshop extends ExpandoCVNode<SimpleWorkshop.ExpandoFields> implements Workshop {

    public enum ExpandoFields {
        LOCATION, INSTRUCTOR;
    }

    private final String workshopName;
    private final DateNode date;
    private final String location;
    private final Collection<String> instructors = new LinkedList<>();

    public SimpleWorkshop(
            String workshopName,
            DateNode date,
            String location,
            Collection<String> instructors,
            Collection<ExpandoCVNodeField<ExpandoFields>> extra
    ) {
        super(extra);
        this.workshopName = requireNonNull(workshopName);
        this.date = requireNonNull(date);
        this.location = location;
        this.instructors.addAll(instructors);
    }

    public Optional<String> getLocation() {
        return Optional.ofNullable(this.location);
    }

}
