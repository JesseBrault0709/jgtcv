package com.brault.jgtcv.musiccv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.musiccv.api.model.experience.MusicExperience;
import com.brault.jgtcv.musiccv.api.model.musicalwork.WorksList;
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWorksList;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

import java.util.Map;

public class SimpleMusicExperience extends SimpleExperience implements MusicExperience {

    public static class Builder implements CVNodeBuilder<SimpleMusicExperience> {

        private final SimpleExperience.Builder simpleBuilder = new SimpleExperience.Builder();

        private WorksList works;

        public Builder works(WorksList works) {
            this.works = works;
            return this;
        }

        public Builder works(
            @DelegatesTo(value = SimpleWorksList.Builder.class, strategy = Closure.DELEGATE_ONLY)
            Closure<?> cl
        ) {
            return this.works(CVNodeBuilder.buildWithClosure(cl, SimpleWorksList.Builder::new));
        }

        public Builder institution(String institution) {
            simpleBuilder.institution(institution);
            return this;
        }

        public Builder date(DateNode date) {
            simpleBuilder.date(date);
            return this;
        }

        public Builder date(Map<String, ?> map) {
            simpleBuilder.date(map);
            return this;
        }

        public Builder role(String role) {
            simpleBuilder.role(role);
            return this;
        }

        public Builder description(String description) {
            simpleBuilder.description(description);
            return this;
        }

        public Builder duties(Duties duties) {
            simpleBuilder.duties(duties);
            return this;
        }

        public Builder duties(Closure<?> cl) {
            simpleBuilder.duties(cl);
            return this;
        }

        @Override
        public SimpleMusicExperience build() {
            return new SimpleMusicExperience(this);
        }

    }

    @Getter
    private final WorksList works;

    public SimpleMusicExperience(Builder b) {
        super(b.simpleBuilder);
        this.works = b.works;
    }

}

