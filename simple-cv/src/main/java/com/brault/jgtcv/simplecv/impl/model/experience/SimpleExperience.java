package com.brault.jgtcv.simplecv.impl.model.experience;

import com.brault.jgtcv.api.model.ExpandoCVNode;
import com.brault.jgtcv.api.model.ExpandoCVNodeField;
import com.brault.jgtcv.simplecv.api.model.date.DateNode;
import com.brault.jgtcv.simplecv.api.model.experience.Experience;
import lombok.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Getter
@ToString(callSuper = true)
public final class SimpleExperience extends ExpandoCVNode<SimpleExperience.ExpandoFields> implements Experience {

    public static final String NODE_TYPE_NAME = "experience";

    public enum ExpandoFields {
        DESCRIPTION;
    }

    @NonNull
    private final String institution;

    @NonNull
    private final DateNode date;

    private final String role;
    private final String description;

    public SimpleExperience(
            Collection<ExpandoCVNodeField<ExpandoFields>> extra,
            String institution,
            DateNode date,
            String role,
            String description
    ) {
        super(extra);
        this.institution = institution;
        this.role = role;
        this.date = date;
        this.description = description;
    }

    public Optional<String> getRole() {
        return Optional.ofNullable(this.role);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.institution, this.role, this.date, this.getExtra());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleExperience) {
            return obj.hashCode() == this.hashCode();
        }
        return false;
    }

}
