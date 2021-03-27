package com.brault.jgtcv.musiccv.experience;

import com.brault.jgtcv.musiccv.musicalwork.Work;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.model.experience.Experience;
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

    @Override
    public Optional<String> getRole() {
        return Optional.ofNullable(this.role);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

}
