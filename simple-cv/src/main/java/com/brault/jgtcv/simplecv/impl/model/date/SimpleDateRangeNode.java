package com.brault.jgtcv.simplecv.impl.model.date;

import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import static java.util.Objects.requireNonNull;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class SimpleDateRangeNode implements DateRangeNode {

    public static DateRangeNode.Builder getBuilder() { return new BuilderImpl(); }

    private static final class BuilderImpl implements DateRangeNode.Builder {
    
        private DateNode start;
        private DateNode end;

        @Override
        public BuilderImpl start(DateNode start) {
            this.start = requireNonNull(start);
            return this;
        }

        @Override
        public BuilderImpl start(Map<String, Object> map) {
            this.start = SimpleDateNode.fromMap(requireNonNull(map));
            return this;
        }

        @Override
        public DateNode start() { return this.start; }

        @Override
        public BuilderImpl end(Map<String, Object> map) {
            this.end = SimpleDateNode.fromMap(requireNonNull(map));
            return this;
        }

        @Override
        public BuilderImpl end(DateNode end) { this.end = requireNonNull(end); return this; }

        @Override
        public DateNode end() { return this.end; }

        @Override
        public DateRangeNode build() {
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
