package com.brault.jgtcv.api.model.position;

import com.brault.jgtcv.api.builder.CVNodeBuilder;
import com.brault.jgtcv.api.model.date.DateRangeNode;
import com.brault.jgtcv.api.model.duties.Duties;
import com.brault.jgtcv.api.model.node.CVNode;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import java.util.Optional;

public interface Position extends CVNode {

    interface Builder extends CVNodeBuilder<Position> {
        Builder institution(String institution);
        String institution();

        Builder role(String role);
        String role();

        Builder dates(DateRangeNode dates);
        Builder dates(
                @DelegatesTo(value = DateRangeNode.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> cl
        );
        DateRangeNode dates();

        Builder duties(Duties duties);
        Builder duties(
                @DelegatesTo(value = Duties.Builder.class, strategy = Closure.DELEGATE_ONLY)
                Closure<?> duties
        );
        Duties duties();
    }

    Optional<Duties> getDuties();
    String getInstitution();
    String getRole();
    DateRangeNode getDates();

}
