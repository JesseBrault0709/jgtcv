package com.brault.jgtcv.simplecv.model.position;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class DutiesBuilder {

    private final Collection<String> duties = new LinkedList<>();

    public DutiesBuilder duty(String duty) {
        this.duties.add(duty);
        return this;
    }

    public DutiesBuilder duties(Collection<String> duties) {
        duties.forEach(this::duty);
        return this;
    }

    public Duties build() {
        return new Duties(List.copyOf(this.duties));
    }

}
