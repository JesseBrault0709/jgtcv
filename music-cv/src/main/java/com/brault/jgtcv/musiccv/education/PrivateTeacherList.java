package com.brault.jgtcv.musiccv.education;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class PrivateTeacherList implements CVNode {

    Collection<String> names;

}
