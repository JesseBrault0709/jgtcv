package com.brault.jgtcv.api.model;

import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a special type of CVNode which allows additional fields (Expando fields) to be added during instantiation,
 * which can then be printed by the corresponding TeX printer.
 *
 * The corresponding TeX printer must print the Expando fields in the correct location.
 *
 * @param <F> The type of the enum whose members represent fields which can take adjacent expando fields.
 */
@ToString
public abstract class ExpandoCVNode<F> implements CVNode {

    private final Collection<ExpandoCVNodeField<F>> extra;

    public ExpandoCVNode(Collection<ExpandoCVNodeField<F>> extra) {
        this.extra = extra;
    }

    public Collection<ExpandoCVNodeField<F>> getExtra() {
        return List.copyOf(this.extra);
    }

    public Collection<CVNode> getExtraBefore(F adjacentField) {
        return this.extra.stream()
                .filter(field ->
                        field.getPosition().equals(ExpandoCVNodeField.Position.BEFORE) &&
                        field.getAdjacentField().equals(adjacentField)
                )
                .map(ExpandoCVNodeField::getNode).collect(Collectors.toList());
    }

    public Collection<CVNode> getExtraAfter(F adjacentField) {
        return this.extra.stream()
                .filter(field ->
                        field.getPosition().equals(ExpandoCVNodeField.Position.AFTER) &&
                        field.getAdjacentField().equals(adjacentField))
                .map(ExpandoCVNodeField::getNode).collect(Collectors.toList());
    }

}
