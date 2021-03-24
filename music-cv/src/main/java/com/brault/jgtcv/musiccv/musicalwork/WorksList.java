package com.brault.jgtcv.musiccv.musicalwork;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class WorksList implements CVNode {

    Collection<Work> works;

}
