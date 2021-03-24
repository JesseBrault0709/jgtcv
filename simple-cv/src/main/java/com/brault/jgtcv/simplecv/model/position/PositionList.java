package com.brault.jgtcv.simplecv.model.position;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.api.model.CVSection;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class PositionList implements CVSection {

    @NonNull
    String sectionName;

    @NonNull
    Collection<Position> positions;

}
