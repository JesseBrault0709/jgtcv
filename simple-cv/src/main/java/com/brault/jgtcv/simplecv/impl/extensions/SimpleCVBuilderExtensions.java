package com.brault.jgtcv.simplecv.impl.extensions;

import com.brault.jgtcv.api.builder.CVBuilder;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleEducation;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperienceList;
import com.brault.jgtcv.simplecv.impl.model.heading.SimpleCVHeading;
import com.brault.jgtcv.simplecv.impl.model.position.SimplePositionList;

import com.brault.jgtcv.simplecv.impl.model.workshop.SimpleWorkshopList;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class SimpleCVBuilderExtensions {

    public static void heading(
            CVBuilder self,
            @DelegatesTo(value = SimpleCVHeading.Builder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new SimpleCVHeading.Builder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void education(
            CVBuilder self,
            @DelegatesTo(value = SimpleEducation.Builder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final var b = new SimpleEducation.Builder();
        cl.setDelegate(b);
        cl.setResolveStrategy(Closure.DELEGATE_ONLY);
        cl.run();
        final var education = b.build();
        self.section(education);
    }

    public static void positions(
            CVBuilder self,
            @DelegatesTo(value = SimplePositionList.Builder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new SimplePositionList.Builder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void experience(
            CVBuilder self,
            @DelegatesTo(value = SimpleExperienceList.Builder.class, strategy = Closure.DELEGATE_ONLY) Closure<?> cl
    ) {
        final var b = new SimpleExperienceList.Builder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }

    public static void workshops(
            CVBuilder self,
            @DelegatesTo(value = SimpleWorkshopList.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new SimpleWorkshopList.Builder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.section(b.build());
    }
    
}
