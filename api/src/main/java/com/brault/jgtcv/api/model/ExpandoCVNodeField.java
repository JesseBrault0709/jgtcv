package com.brault.jgtcv.api.model;

import lombok.Value;

/**
 * An object for holding information about an ExpandoField, indicating where it is placed
 * relative to its parent and its value.
 *
 * @param <F> The type of the enum whose members represent fields which can take adjacent
 *           Expando fields.
 */
@Value
public class ExpandoCVNodeField<F> {

    public enum Position {
        BEFORE, AFTER;
    }

    Position position;
    F adjacentField;
    CVNode node;

}
