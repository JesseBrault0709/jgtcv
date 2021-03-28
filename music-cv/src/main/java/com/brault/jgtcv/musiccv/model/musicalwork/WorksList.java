package com.brault.jgtcv.musiccv.model.musicalwork;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;

@Value
public class WorksList implements CVNode {

    Collection<Work> works;

}
