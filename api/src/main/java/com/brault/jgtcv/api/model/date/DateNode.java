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

public interface DateNode extends CVNode {

    Optional<Year> asYear();
    Optional<YearMonth> asYearMonth();
    Optional<LocalDate> asLocalDate();

//
//    Map<String, Integer> MONTH_INDICES = Map.ofEntries(
//            new SimpleEntry<>("January", 1),
//            new SimpleEntry<>("February", 2),
//            new SimpleEntry<>("March", 3),
//            new SimpleEntry<>("April", 4),
//            new SimpleEntry<>("May", 5),
//            new SimpleEntry<>("June", 6),
//            new SimpleEntry<>("July", 7),
//            new SimpleEntry<>("August", 8),
//            new SimpleEntry<>("September", 9),
//            new SimpleEntry<>("October", 10),
//            new SimpleEntry<>("November", 11),
//            new SimpleEntry<>("December", 12)
//    );
//
//    Comparator<DateNode> COMPARATOR =
//            Comparator.comparingInt((DateNode dn) -> dn.getYear().orElse(0))
//                    .thenComparing((DateNode dn1, DateNode dn2) -> {
//                        if (dn1.getMonth().isEmpty()) {
//                            return -1;
//                        } else if (dn2.getMonth().isEmpty()) {
//                            return 1;
//                        }
//                        final int dn1MonthIndex = MONTH_INDICES.get(dn1.getMonth().get());
//                        final int dn2MonthIndex = MONTH_INDICES.get(dn2.getMonth().get());
//                        return Integer.compare(dn1MonthIndex, dn2MonthIndex);
//                    })
//                    .thenComparingInt(dn -> dn.getDay().orElse(0));
//
//    Optional<Integer> getDay();
//    Optional<String> getMonth();
//    Optional<Integer> getYear();
//
//    @Override
//    default int compareTo(DateNode o) {
//        return COMPARATOR.compare(this, o);
//    }

}
