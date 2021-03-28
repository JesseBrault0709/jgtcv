package com.brault.jgtcv.musiccv.extensions;

import com.brault.jgtcv.musiccv.model.experience.MusicalWorkExperienceBuilder;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperienceListBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class ExperienceListExtensions {

    public static void musicalWorkExp(
            SimpleExperienceListBuilder self,
            @DelegatesTo(value = MusicalWorkExperienceBuilder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var b = new MusicalWorkExperienceBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        self.exp(b.build());
    }

}
