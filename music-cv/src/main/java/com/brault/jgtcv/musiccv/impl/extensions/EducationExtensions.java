package com.brault.jgtcv.musiccv.impl.extensions;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.musiccv.impl.model.education.SimpleMusicDegree;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleEducation;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class EducationExtensions {

    public static void musicDegree(
            SimpleEducation.Builder self,
            @DelegatesTo(value = SimpleMusicDegree.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
    ) {
        final var degree = CVNodeBuilder.buildWithClosure(cl, SimpleMusicDegree.Builder::new);
        self.degree(degree);
    }

}
