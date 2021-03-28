package com.brault.jgtcv.musiccv.model.education;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;

@Value
public class PrivateTeacherList implements CVNode {

    Collection<String> names;

}
