package com.brault.jgtcv.musiccv.experience;

import com.brault.jgtcv.musiccv.musicalwork.Work;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
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

    private Work work;

    public MusicalWorkExperienceBuilder date(Map<String, Object> args) {
        this.date = SimpleDateNode.fromMap(args);
        return this;
    }

    public MusicalWorkExperienceBuilder work(Map<String, Object> args) {
        this.work = Work.fromMap(args);
        return this;
    }

    public MusicalWorkExperience build() {
        return new MusicalWorkExperience(this.date, this.work, this.institution, this.role, this.description);
    }

}
