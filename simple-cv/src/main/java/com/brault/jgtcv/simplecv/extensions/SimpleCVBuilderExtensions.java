package com.brault.jgtcv.simplecv.extensions;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshopBuilder;
import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshopList;
import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshopListBuilder;
import com.brault.jgtcv.simplecv.model.education.EducationBuilder;

import com.brault.jgtcv.simplecv.model.experience.ExperienceListBuilder;
import com.brault.jgtcv.simplecv.model.heading.CVHeadingBuilder;
import com.brault.jgtcv.simplecv.model.position.PositionListBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class SimpleCVBuilderExtensions {

    public static void heading(
            CVBuilder self,
            @DelegatesTo(value = CVHeadingBuilder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new CVHeadingBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void education(
            CVBuilder self,
            @DelegatesTo(value = EducationBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new EducationBuilder();
        cl.setDelegate(b);
        cl.setResolveStrategy(Closure.DELEGATE_ONLY);
        cl.run();
        final var education = b.build();
        self.section(education);
    }

    public static void positions(
            CVBuilder self,
            @DelegatesTo(value = PositionListBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new PositionListBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void experience(
            CVBuilder self,
            @DelegatesTo(value = ExperienceListBuilder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new ExperienceListBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void workshops(
            CVBuilder self,
            @DelegatesTo(value = SimpleWorkshopListBuilder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new SimpleWorkshopListBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }
    
}
