package com.brault.jgtcv.musiccv.model.education;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class PrivateTeacherListBuilder {

    private final Collection<String> names = new LinkedList<>();

    public PrivateTeacherListBuilder name(String name) {
        this.names.add(name);
        return this;
    }

    public PrivateTeacherList build() {
        return new PrivateTeacherList(List.copyOf(this.names));
    }

}
