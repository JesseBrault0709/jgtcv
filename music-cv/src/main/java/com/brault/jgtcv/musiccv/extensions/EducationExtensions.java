package com.brault.jgtcv.musiccv.extensions;

import com.brault.jgtcv.musiccv.education.PrivateTeacherList;
import com.brault.jgtcv.musiccv.education.PrivateTeacherListBuilder;
import com.brault.jgtcv.simplecv.model.education.Degree;
import com.brault.jgtcv.simplecv.model.education.DegreeBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class EducationExtensions {

    public static DegreeBuilder privateTeachers(
            DegreeBuilder self,
            @DelegatesTo(value = PrivateTeacherListBuilder.class, strategy = Closure.DELEGATE_FIRST) Closure<?> cl
    ) {
        final PrivateTeacherListBuilder builder = new PrivateTeacherListBuilder();
        final Closure<?> rehydrated = cl.rehydrate(builder, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        final PrivateTeacherList privateTeacherList = builder.build();
        self.before(Degree.ExpandoFields.RELEVANT_COURSEWORK, privateTeacherList);
        return self;
    }

}
