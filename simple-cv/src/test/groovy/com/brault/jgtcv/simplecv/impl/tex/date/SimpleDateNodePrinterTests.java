package com.brault.jgtcv.simplecv.impl.tex.date;

import com.brault.jgtcv.api.tex.TexPrinter;
import com.brault.jgtcv.api.tex.TexPrintingContext;
import com.brault.jgtcv.simplecv.impl.model.date.SimpleDateNode;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public final class SimpleDateNodePrinterTests {

    private static TexPrinter<SimpleDateNode> getPrinter() {
        final var script = new SimpleDateNodePrinter();
        return (TexPrinter<SimpleDateNode>) script.run();
    }

    /**
     * Shouldn't need any printers in the context since we are using a terminal node.
     */
    private final TexPrintingContext context = new TexPrintingContext(new ArrayList<>());

    @Test
    public void ensureCorrectPrinterFor() {
        final var printer = getPrinter();
        assertEquals(SimpleDateNode.class, printer.getPrinterFor());
    }

    @Test
    public void giveYear() {
        final var printer = getPrinter();
        final Year year = Year.of(2021);
        final var dn = new SimpleDateNode(year);
        assertEquals("2021", printer.printTex(this.context, dn));
    }

    @Test
    public void giveYearMonthNoAbbrev() {
        final var printer = getPrinter();
        final YearMonth yearMonth = YearMonth.of(2021, Month.MAY);
        final var dn = new SimpleDateNode(yearMonth);
        assertEquals("May 2021", printer.printTex(this.context, dn));
    }

    @Test
    public void giveYearMonthAbbrev() {
        final var printer = getPrinter();
        final YearMonth yearMonth = YearMonth.of(2021, Month.DECEMBER);
        final var dn = new SimpleDateNode(yearMonth);
        assertEquals("Dec.~2021", printer.printTex(this.context, dn));
    }

    @Test
    public void giveLocalDateNoAbbrev() {
        final LocalDate localDate = LocalDate.of(2021, Month.MAY, 29);
        final var dn = new SimpleDateNode(localDate);
        assertEquals("29 May 2021", getPrinter().printTex(this.context, dn));
    }

    @Test
    public void giveLocalDateAbbrev() {
        final LocalDate localDate = LocalDate.of(2021, Month.DECEMBER, 25);
        final var dn = new SimpleDateNode(localDate);
        assertEquals("25 Dec.~2021", getPrinter().printTex(this.context, dn));
    }

}
