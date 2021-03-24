package com.brault.jgtcv.api.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * A builder for ExpandoCVNodes.
 *
 * @param <T> The type of the built node.
 * @param <F> The type of the enum whose members represent fields which can take adjacent
 *           Expando fields.
 */
public abstract class ExpandoCVNodeBuilder<T, F> {

    abstract public T build();

    private final Collection<ExpandoCVNodeField<F>> extra = new LinkedList<>();

    public void before(F adjacentField, CVNode node) {
        this.extra.add(new ExpandoCVNodeField<>(ExpandoCVNodeField.Position.BEFORE, adjacentField, node));
    }

    public void after(F adjacentField, CVNode node) {
        this.extra.add(new ExpandoCVNodeField<>(ExpandoCVNodeField.Position.AFTER, adjacentField, node));
    }

    protected Collection<ExpandoCVNodeField<F>> getExtra() {
        return List.copyOf(this.extra);
    }

}
