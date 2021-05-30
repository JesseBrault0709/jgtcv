package com.brault.jgtcv.musiccv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.musiccv.api.model.musicalwork.Work;
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWork;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

import java.util.Map;

public class SimpleMusicalWorkExperience extends SimpleExperience {

    public static class Builder implements CVNodeBuilder<SimpleMusicalWorkExperience> {

        private final SimpleExperience.Builder simpleExperienceBuilder = new SimpleExperience.Builder();

        private Work work;

        public Builder work(Work work) {
            this.work = work;
            return this;
        }

        /**
         * @implSpec Calls this.work(Work) and returns its value.
         *
         * @param cl
         * @return
         */
        public Builder work(
                @DelegatesTo(value = SimpleWork.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        ) {
            return this.work(CVNodeBuilder.buildWithClosure(cl, SimpleWork.Builder::new));
        }

        /**
         * @implSpec Calls this.work(Work) and returns its value.
         *
         * @param map
         * @return
         */
        public Builder work(Map<String, ?> map) {
            return this.work(SimpleWork.fromMap(map));
        }

        public Builder institution(String institution) {
            simpleExperienceBuilder.institution(institution);
            return this;
        }

        public Builder date(DateNode date) {
            simpleExperienceBuilder.date(date);
            return this;
        }

        public Builder date(Map<String, ?> map) {
            simpleExperienceBuilder.date(map);
            return this;
        }

        public Builder role(String role) {
            simpleExperienceBuilder.role(role);
            return this;
        }

        public Builder description(String description) {
            simpleExperienceBuilder.description(description);
            return this;
        }

        public Builder duties(Duties duties) {
            simpleExperienceBuilder.duties(duties);
            return this;
        }

        public Builder duties(Closure<?> cl) {
            simpleExperienceBuilder.duties(cl);
            return this;
        }

        public SimpleMusicalWorkExperience build() {
            return new SimpleMusicalWorkExperience(this);
        }

    }


    @Getter
    private final Work work;

    public SimpleMusicalWorkExperience(Builder b) {
        super(b.simpleExperienceBuilder);
        this.work = b.work;
    }

}
