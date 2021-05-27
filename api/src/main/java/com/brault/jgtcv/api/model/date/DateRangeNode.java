package com.brault.jgtcv.api.model.date;

import com.brault.jgtcv.api.model.node.CVNode;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

public interface DateRangeNode extends CVNode {

    Optional<DateNode> getStart();
    Optional<DateNode> getEnd();

}
