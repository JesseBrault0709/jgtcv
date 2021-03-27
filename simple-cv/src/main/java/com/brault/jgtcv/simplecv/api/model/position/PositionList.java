package com.brault.jgtcv.simplecv.api.model.position;

import com.brault.jgtcv.api.model.CVSection;

import java.util.Collection;

public interface PositionList extends CVSection {
    Collection<Position> getPositions();
}
