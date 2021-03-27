package com.brault.jgtcv.musiccv.extensions;

import com.brault.jgtcv.musiccv.musicalwork.WorksListBuilder;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperienceBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class ExperienceExtensions {

    public static SimpleExperienceBuilder works(
            SimpleExperienceBuilder self,
            @DelegatesTo(value = WorksListBuilder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new WorksListBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.after(SimpleExperience.ExpandoFields.DESCRIPTION, b.build());
        return self;
    }

}
