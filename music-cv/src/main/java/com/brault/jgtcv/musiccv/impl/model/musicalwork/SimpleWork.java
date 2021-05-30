package com.brault.jgtcv.musiccv.impl.model.musicalwork;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.musiccv.api.model.musicalwork.Work;
import com.brault.jgtcv.musiccv.api.model.musicalwork.WorkTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor @Getter
public class SimpleWork implements Work {

    /**
     * Only does non-italic titles.
     *
     * @param args
     * @return
     */
    public static SimpleWork fromMap(Map<String, ?> args) {
        final String title = (String) args.get("title");
        final String composer = (String) args.get("composer");
        final String movements = (String) args.get("movements");

        return new SimpleWork(new SimpleWorkTitle(title), composer, movements);
    }

    public static class Builder implements CVNodeBuilder<SimpleWork> {

        private WorkTitle title;
        private String composer;
        private String movements;

        public Builder title(String title) {
            this.title = new SimpleWorkTitle(title);
            return this;
        }

        public Builder italicTitle(String title) {
            this.title = new ItalicWorkTitle(title);
            return this;
        }

        public Builder composer(String composer) {
            this.composer = composer;
            return this;
        }

        public Builder movements(String movements) {
            this.movements = movements;
            return this;
        }

        public SimpleWork build() {
            return new SimpleWork(this);
        }

    }

    private final WorkTitle title;
    private final String composer;
    private final String movements;

    public SimpleWork(Builder b) {
        this.title = b.title;
        this.composer = b.composer;
        this.movements = b.movements;
    }

}
