package com.brault.jgtcv.musiccv.model.experience;

import com.brault.jgtcv.musiccv.model.musicalwork.Work;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.duties.Duties;
import com.brault.jgtcv.simplecv.api.model.experience.Experience;
import lombok.NonNull;
import lombok.Value;

import java.util.Optional;

@Value
public class MusicalWorkExperience implements Experience {

    @NonNull
    DateNode date;

    @NonNull
    Work work;

    String institution;
    String role;
    String description;
    Duties duties;

    @Override
    public Optional<String> getRole() {
        return Optional.ofNullable(this.role);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

    @Override
    public Optional<Duties> getDuties() { return Optional.ofNullable(this.duties); }

}
