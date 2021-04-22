package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.model.ExpandoCVNodeBuilder;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.duties.Duties;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import com.brault.jgtcv.simplecv.impl.model.duties.SimpleDutiesBuilder;
import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Setter
@Getter
@Accessors(fluent = true)
public class SimpleExperienceBuilder extends ExpandoCVNodeBuilder<SimpleExperience, SimpleExperience.ExpandoFields> {

    private String institution;
    private DateNode date;

    private String role;
    private String description;
    private Duties duties;

    public SimpleExperienceBuilder date(Map<String, ?> date) {
        this.date = SimpleDateNode.fromMap(date);
        return this;
    }

    public SimpleExperienceBuilder duties(Closure<?> cl) {
        final var b = new SimpleDutiesBuilder();
        final var rehydrated = cl.rehydrate(b, cl.getOwner(), cl.getThisObject());
        rehydrated.run();
        this.duties = b.build();
        return this;
    }

    @Override
    public SimpleExperience build() {
        return new SimpleExperience(this.getExtra(), this.institution, this.date, this.role, this.description, this.duties);
    }

}
