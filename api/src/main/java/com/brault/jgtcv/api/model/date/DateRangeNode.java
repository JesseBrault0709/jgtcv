package com.brault.jgtcv.api.model.date;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.node.CVNode;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface DateRangeNode extends CVNode {

    interface Builder extends CVNodeBuilder<DateRangeNode> {
        Builder start(DateNode start);
        Builder start(Map<String, Object> map);
        DateNode start();

        Builder end(DateNode end);
        Builder end(Map<String, Object> map);
        DateNode end();
    }

    Optional<DateNode> getStart();
    Optional<DateNode> getEnd();

}
