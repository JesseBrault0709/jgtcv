package com.brault.jgtcv.simplecv.impl.model.workshop;

import com.brault.jgtcv.simplecv.api.model.workshop.Workshop;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SimpleWorkshopListBuilder {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private String sectionName = "Workshops";

    private final Collection<Workshop> workshops = new LinkedList<>();

    public SimpleWorkshopListBuilder workshop(Workshop workshop) {
        this.workshops.add(workshop);
        return this;
    }

    public SimpleWorkshopListBuilder workshop(
            @DelegatesTo(value = SimpleWorkshopBuilder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new SimpleWorkshopBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        this.workshops.add(b.build());
        return this;
    }

    public SimpleWorkshopList build() {
        return new SimpleWorkshopList(this.sectionName, List.copyOf(this.workshops));
    }

}
