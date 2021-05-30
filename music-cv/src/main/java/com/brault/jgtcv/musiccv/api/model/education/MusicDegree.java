package com.brault.jgtcv.musiccv.api.model.education;

import com.brault.jgtcv.api.model.education.Degree;

import java.util.Collection;

public interface MusicDegree extends Degree {
    Collection<String> getPrivateTeachers();
}
