package com.brault.jgtcv.musiccv.model.musicalwork;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

@Value
public class WorkTitle implements CVNode {
    
    String title;
    boolean italicized;

}
