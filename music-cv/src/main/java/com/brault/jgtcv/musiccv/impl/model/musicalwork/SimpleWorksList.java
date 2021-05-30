package com.brault.jgtcv.musiccv.impl.model.musicalwork;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.musiccv.api.model.musicalwork.Work;
import com.brault.jgtcv.musiccv.api.model.musicalwork.WorksList;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class SimpleWorksList implements WorksList {

    public static class Builder implements CVNodeBuilder<SimpleWorksList> {

        private final Collection<Work> works = new LinkedList<>();

        public Builder work(Work work) {
            this.works.add(work);
            return this;
        }

        /**
         * @implSpec Calls and returns the value of this.work(Work work).
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
         * @implSpec Calls and returns the value of this.work(Work work).
         *
         * @param map
         * @return
         */
        public Builder work(Map<String, ?> map) {
           return this.work(SimpleWork.fromMap(map));
        }

        @Override
        public SimpleWorksList build() {
            return new SimpleWorksList(this);
        }

    }

    @Getter
    private final Collection<Work> works;

    public SimpleWorksList(Builder b) {
        this.works = b.works;
    }

}
