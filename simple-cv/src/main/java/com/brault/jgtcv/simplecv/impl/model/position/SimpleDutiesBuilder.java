package com.brault.jgtcv.simplecv.impl.model.position;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class SimpleDutiesBuilder {

    private final Collection<String> duties = new LinkedList<>();

    public SimpleDutiesBuilder duty(String duty) {
        this.duties.add(duty);
        return this;
    }

    public SimpleDutiesBuilder duties(Collection<String> duties) {
        duties.forEach(this::duty);
        return this;
    }

    public SimpleDuties build() {
        return new SimpleDuties(List.copyOf(this.duties));
    }

}
