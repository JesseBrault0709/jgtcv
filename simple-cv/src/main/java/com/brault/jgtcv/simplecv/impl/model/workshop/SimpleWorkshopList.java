package com.brault.jgtcv.simplecv.impl.model.workshop;


import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.workshop.Workshop;
import com.brault.jgtcv.api.model.workshop.WorkshopList;
import com.brault.jgtcv.simplecv.impl.model.section.AbstractCVSection;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

@Getter
public class SimpleWorkshopList extends AbstractCVSection implements WorkshopList {

    public static class Builder extends AbstractCVSection.Builder<Builder, SimpleWorkshopList> {

        private final Collection<Workshop> workshops = new LinkedList<>();

        public Builder workshop(Workshop workshop) {
            this.workshops.add(workshop);
            return this.self();
        }

        public Builder workshop(
                @DelegatesTo(value = SimpleWorkshop.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            this.workshops.add(CVNodeBuilder.buildWithClosure(cl, SimpleWorkshop.Builder::new));
            return this.self();
        }

        @Override
        public SimpleWorkshopList build() {
            return new SimpleWorkshopList(this);
        }

        @Override
        protected Builder self() { return this; }

    }

    private final Collection<Workshop> workshops;

    public SimpleWorkshopList(Builder b) {
        super(b);
        this.workshops = b.workshops;
    }

}
