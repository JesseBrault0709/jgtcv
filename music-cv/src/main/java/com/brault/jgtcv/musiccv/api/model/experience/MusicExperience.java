package com.brault.jgtcv.musiccv.api.model.experience;

import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.musiccv.api.model.musicalwork.WorksList;

public interface MusicExperience extends Experience {
    WorksList getWorks();
}
