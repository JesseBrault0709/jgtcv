package com.brault.jgtcv.musiccv.musicalwork;

import com.brault.jgtcv.api.model.CVNode;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Value
public class Work implements CVNode {

    public static Work fromMap(Map<String, Object> args) {
        final String title = (String) args.get("title");
        final Boolean italicized = (Boolean) args.getOrDefault("italicized", false);
        final String composer = (String) args.get("composer");
        final String movements = (String) args.get("movements");

        return new Work(new WorkTitle(title, italicized), composer, movements);
    }

    WorkTitle title;
    String composer;
    String movements;

}
