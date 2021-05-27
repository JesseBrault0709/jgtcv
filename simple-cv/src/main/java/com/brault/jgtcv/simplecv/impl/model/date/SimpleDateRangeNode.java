package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleDateRangeNode implements DateRangeNode {

    public static class Builder implements CVNodeBuilder<SimpleDateRangeNode> {
    
        private DateNode start;
        private DateNode end;

        public Builder start(Map<String, Object> map) {
            this.start = SimpleDateNode.fromMap(map);
            return this;
        }

        public Builder end(Map<String, Object> map) {
            this.end = SimpleDateNode.fromMap(map);
            return this;
        }

        public SimpleDateRangeNode build() {
            return new SimpleDateRangeNode(this.start, this.end);
        }

    }

    private final DateNode start;
    private final DateNode end;

    @Override
    public Optional<DateNode> getStart() {
        return Optional.ofNullable(this.start);
    }

    @Override
    public Optional<DateNode> getEnd() {
        return Optional.ofNullable(this.end);
    }

}
