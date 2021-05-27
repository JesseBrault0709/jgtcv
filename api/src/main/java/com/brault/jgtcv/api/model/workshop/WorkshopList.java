package com.brault.jgtcv.api.model.workshop;

import com.brault.jgtcv.api.model.section.CVSection;

import java.util.Collection;

public interface WorkshopList extends CVSection {

    Collection<Workshop> getWorkshops();

}
