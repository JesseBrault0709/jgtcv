package com.brault.jgtcv.simplecv.impl.model.workshop;

import com.brault.jgtcv.simplecv.api.model.workshop.Workshop;
import com.brault.jgtcv.simplecv.api.model.workshop.WorkshopList;
import lombok.Value;

import java.util.Collection;

@Value
public class SimpleWorkshopList implements WorkshopList {

    String sectionName;
    Collection<Workshop> workshops;

}
