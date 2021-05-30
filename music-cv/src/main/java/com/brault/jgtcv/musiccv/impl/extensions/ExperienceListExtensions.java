package com.brault.jgtcv.musiccv.impl.extensions;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.musiccv.impl.model.experience.SimpleMusicalWorkExperience;
import com.brault.jgtcv.musiccv.impl.model.experience.SimpleMusicExperience;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperienceList;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public final class ExperienceListExtensions {

    public static void musicalWorkExp(
            SimpleExperienceList.Builder self,
            @DelegatesTo(value = SimpleMusicalWorkExperience.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        self.experience(CVNodeBuilder.buildWithClosure(cl, SimpleMusicalWorkExperience.Builder::new));
    }

    public static void musicExp(
        SimpleExperienceList.Builder self,
        @DelegatesTo(value = SimpleMusicExperience.Builder.class, strategy = Closure.DELEGATE_ONLY)
        Closure<?> cl
    ) {
        self.experience(CVNodeBuilder.buildWithClosure(cl, SimpleMusicExperience.Builder::new));
    }

}
