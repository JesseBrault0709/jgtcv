package com.brault.jgtcv.musiccv.impl.model.musicalwork;

import com.brault.jgtcv.musiccv.api.model.musicalwork.WorkTitle;
import lombok.Value;

@Value
public class SimpleWorkTitle implements WorkTitle {

    String title;

}
