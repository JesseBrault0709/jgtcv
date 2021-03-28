package com.brault.jgtcv.musiccv.extensions;

import com.brault.jgtcv.musiccv.model.education.PrivateTeacherList;
import com.brault.jgtcv.musiccv.model.education.PrivateTeacherListBuilder;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegreeBuilder;
import com.brault.jgtcv.simplecv.impl.model.education.SimpleDegree;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class EducationExtensions {

    public static SimpleDegreeBuilder privateTeachers(
            SimpleDegreeBuilder self,
            @DelegatesTo(value = PrivateTeacherListBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final PrivateTeacherListBuilder builder = new PrivateTeacherListBuilder();
        final Closure<?> rehydrated = cl.rehydrate(builder, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        final PrivateTeacherList privateTeacherList = builder.build();
        self.before(SimpleDegree.ExpandoFields.RELEVANT_COURSEWORK, privateTeacherList);
        return self;
    }

}
