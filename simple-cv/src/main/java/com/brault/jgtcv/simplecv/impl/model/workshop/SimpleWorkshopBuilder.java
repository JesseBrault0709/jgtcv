package com.brault.jgtcv.simplecv.impl.model.workshop;

import com.brault.jgtcv.api.model.ExpandoCVNodeBuilder;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class SimpleWorkshopBuilder extends ExpandoCVNodeBuilder<SimpleWorkshop, SimpleWorkshop.ExpandoFields> {

    private String workshopName;
    private DateNode date;
    private String location;

    private final Collection<String> instructors = new LinkedList<>();

    public SimpleWorkshopBuilder date(Map<String, Object> args) {
        this.date = SimpleDateNode.fromMap(args);
        return this;
    }

    public SimpleWorkshopBuilder instructor(String instructor) {
        this.instructors.add(instructor);
        return this;
    }

    public SimpleWorkshopBuilder instructors(Collection<String> instructors) {
        this.instructors.addAll(instructors);
        return this;
    }

    @Override
    public SimpleWorkshop build() {
        return new SimpleWorkshop(this.workshopName, this.date, this.location, this.instructors, this.getExtra());
    }

}
