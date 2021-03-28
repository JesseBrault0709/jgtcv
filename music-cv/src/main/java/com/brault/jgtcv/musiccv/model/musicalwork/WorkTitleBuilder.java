package com.brault.jgtcv.musiccv.model.musicalwork;

public final class WorkTitleBuilder {

    private String title;
    private boolean italicized;

    public WorkTitleBuilder title(String title) {
        this.title = title;
        return this;
    }

    public WorkTitleBuilder italicized(boolean italicized) {
        this.italicized = italicized;
        return this;
    }

    public WorkTitle build() {
        return new WorkTitle(title, italicized);
    }
    
}

