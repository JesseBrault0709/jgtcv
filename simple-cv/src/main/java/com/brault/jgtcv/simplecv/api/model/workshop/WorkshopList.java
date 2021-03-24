package com.brault.jgtcv.simplecv.api.model.workshop;

import com.brault.jgtcv.api.model.CVSection;

import java.util.Collection;

public interface WorkshopList extends CVSection {

    Collection<Workshop> getWorkshops();

}
