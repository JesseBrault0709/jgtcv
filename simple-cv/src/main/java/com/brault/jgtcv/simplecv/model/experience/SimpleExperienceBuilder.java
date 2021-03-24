package com.brault.jgtcv.simplecv.model.experience;

import com.brault.jgtcv.api.model.ExpandoCVNodeBuilder;
import com.brault.jgtcv.simplecv.model.date.DateNode;
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
        this.date = DateNode.fromMap(date);
        return this;
    }

    @Override
    public SimpleExperience build() {
        return new SimpleExperience(this.getExtra(), this.institution, this.date, this.role, this.description);
    }

}
