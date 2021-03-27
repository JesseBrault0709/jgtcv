package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.model.ExpandoCVNodeBuilder;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
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

    public SimpleExperienceBuilder date(Map<String, ?> date) {
        this.date = SimpleDateNode.fromMap(date);
        return this;
    }

    @Override
    public SimpleExperience build() {
        return new SimpleExperience(this.getExtra(), this.institution, this.date, this.role, this.description);
    }

}
