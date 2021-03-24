package com.brault.jgtcv.api.tex;

import lombok.Value;

import java.util.Map;

/**
 * A container for the printed CV, including its source as well as macro files.
 */
@Value
public class PrintedTexCV {

    String source;
    Map<String, String> macroFileNamesAndSources;

}
