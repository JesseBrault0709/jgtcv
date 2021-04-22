package com.brault.jgtcv.simplecv.impl.model.duties;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class SimpleDutiesBuilder {

    private final Collection<String> duties = new LinkedList<>();
    private boolean presentTense = false; // default is past tense

    public SimpleDutiesBuilder duty(String duty) {
        this.duties.add(duty);
        return this;
    }

    public SimpleDutiesBuilder duties(Collection<String> duties) {
        duties.forEach(this::duty);
        return this;
    }

    public SimpleDutiesBuilder presentTense(boolean isPresentTense) {
        this.presentTense = isPresentTense;
        return this;
    }

    public SimpleDuties build() {
        return new SimpleDuties(List.copyOf(this.duties), this.presentTense);
    }

}
