package com.brault.jgtcv.musiccv.impl.model.experience;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.experience.Experience;
import com.brault.jgtcv.musiccv.api.model.musicalwork.Work;
import com.brault.jgtcv.musiccv.impl.model.musicalwork.SimpleWork;
import com.brault.jgtcv.simplecv.impl.model.experience.SimpleExperience;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

import java.util.Map;

public class SimpleMusicalWorkExperience extends SimpleExperience {

    public static class Builder extends Experience.ForwardingBuilder {

        private Work work;

        public Builder() { super(SimpleExperience.getBuilder()); }

        public Builder work(Work work) { this.work = work; return this; }

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

        @Override
        public SimpleMusicalWorkExperience build() {
            return new SimpleMusicalWorkExperience(this);
        }

    }


    @Getter
    private final Work work;

    public SimpleMusicalWorkExperience(Builder b) {
        super(b);
        this.work = b.work;
    }

}
