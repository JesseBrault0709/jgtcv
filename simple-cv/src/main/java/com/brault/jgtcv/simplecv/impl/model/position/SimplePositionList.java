package com.brault.jgtcv.simplecv.impl.model.position;

import com.brault.jgtcv.simplecv.api.model.position.Position;
import com.brault.jgtcv.simplecv.api.model.position.PositionList;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class SimplePositionList implements PositionList {

    @NonNull
    String sectionName;

    @NonNull
    Collection<Position> positions;

}
