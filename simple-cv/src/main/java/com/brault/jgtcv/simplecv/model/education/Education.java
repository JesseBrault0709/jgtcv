package com.brault.jgtcv.simplecv.model.education;

import java.util.Collection;
import java.util.LinkedList;

import com.brault.jgtcv.api.model.CVNode;
import com.brault.jgtcv.api.model.CVSection;

import lombok.NonNull;
import lombok.Value;

@Value
public class Education implements CVSection {

    @NonNull
    String sectionName;

    @NonNull
    Collection<Degree> degrees;

}
