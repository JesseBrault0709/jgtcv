package com.brault.jgtcv.simplecv.api.model.date;

import java.util.Optional;

public interface DateNode {

    Optional<Integer> getDay();
    Optional<String> getMonth();
    Optional<Integer> getYear();

}
