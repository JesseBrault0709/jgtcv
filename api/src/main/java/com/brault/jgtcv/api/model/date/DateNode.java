package com.brault.jgtcv.api.model.date;

import com.brault.jgtcv.api.model.node.CVNode;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static java.util.AbstractMap.SimpleEntry;

/**
 * A node representing a date. This is a terminal node,
 * i.e., it does not contain any child nodes.
 */
public interface DateNode extends CVNode {

    /**
     * @return An Optional containing a Year instance, if
     * there is enough information in the node for a Year
     * instance, else an empty Optional.
     */
    Optional<Year> asYear();

    /**
     * @return An Optional containing a YearMonth instance,
     * if there is enough information in the node for such
     * an instance, else an empty Optional.
     */
    Optional<YearMonth> asYearMonth();

    /**
     * @return An Optional containing a LocalDate instance,
     * if there is enough information in the node for such
     * an instance, else an empty Optional.
     */
    Optional<LocalDate> asLocalDate();

}
