package com.brault.jgtcv.api.model.position;

import com.brault.jgtcv.api.model.section.CVSection;

import java.util.Collection;

public interface PositionList extends CVSection {

    Collection<Position> getPositions();

}
