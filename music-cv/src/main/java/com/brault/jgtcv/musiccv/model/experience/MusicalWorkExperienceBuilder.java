package com.brault.jgtcv.musiccv.model.experience;

import com.brault.jgtcv.musiccv.model.musicalwork.Work;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.duties.Duties;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDutiesBuilder;
import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Getter
@Setter
@Accessors(fluent = true)
public class MusicalWorkExperienceBuilder {

    private String institution;
    private DateNode date;
    private String role;
    private String description;
    private Duties duties;

    private Work work;

    public MusicalWorkExperienceBuilder date(Map<String, Object> args) {
        this.date = SimpleDateNode.fromMap(args);
        return this;
    }

    public MusicalWorkExperienceBuilder work(Map<String, Object> args) {
        this.work = Work.fromMap(args);
        return this;
    }

    public MusicalWorkExperienceBuilder duties(Closure<?> cl) {
        final var b = new SimpleDutiesBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.setResolveStrategy(Closure.DELEGATE_ONLY);
        rehydrated.run();
        this.duties = b.build();
        return this;
    }

    public MusicalWorkExperience build() {
        return new MusicalWorkExperience(this.date, this.work, this.institution, this.role, this.description, this.duties);
    }

}
