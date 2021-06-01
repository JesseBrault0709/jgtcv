package com.brault.jgtcv.musiccv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.musiccv.api.model.experience.MusicExperience;
import com.brault.jgtcv.musiccv.api.model.musicalwork.WorksList;
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorksList;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

public class SimpleMusicExperience extends SimpleExperience implements MusicExperience {

    public static class Builder extends Experience.ForwardingBuilder {

        private WorksList works;

        public Builder() { super(SimpleExperience.getBuilder()); }

        public Builder works(WorksList works) { this.works = works; return this; }

        public Builder works(
            @DelegatesTo(value = SimpleWorksList.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
        ) {
            return this.works(CVNodeBuilder.buildWithClosure(cl, SimpleWorksList.Builder::new));
        }

        @Override
        public SimpleMusicExperience build() {
            return new SimpleMusicExperience(this);
        }

    }

    @Getter
    private final WorksList works;

    public SimpleMusicExperience(Builder b) {
        super(b);
        this.works = b.works;
    }

}

