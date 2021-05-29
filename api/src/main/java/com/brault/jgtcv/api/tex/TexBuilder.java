package com.brault.jgtcv.api.tex;

import com.brault.jgtcv.api.model.node.CVNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Map;

/**
 * The delegate to the closure argument of the printer() method in TexPrinter. Similar to
 * a StringBuilder, takes input and appends/prepends it before the TeX result is built.
 *
 * N.B.: tex(), texStrings(), or texNodes() should be called first in any printer, before any calls to texln(),
 * texlnStrings(), or texlnNodes(), or other methods which start on a new line.
 *
 * @param <T> The type of the object to be printed.
 */
public class TexBuilder<T> {

    private static final Logger logger = LogManager.getLogger();

    private final StringBuilder b = new StringBuilder();
    private final TexPrintingContext context;
    private final T item;

    public TexBuilder(TexPrintingContext context, T item) {
        this.context = context;
        this.item = item;
    }

    public String build() {
        return this.b.toString();
    }

    private boolean endsWithNewLine() {
        final var length = b.length();
        if (
                length > 0 &&
                b.substring(length - 1, length) == "\n"
        ) {
            return true;
        } else {
            return false;
        }
    }

    private <U> String printNode(U node) {
        final var printerOpt = this.context.getPrinterFor(node);
        if (printerOpt.isEmpty()) {
            logger.warn("there is no TexPrinter for target class {}", node.getClass().getName());
            return "";
        } else {
            return printerOpt.get().printTex(this.context, node);
        }
    }

    /**
     * Appends the string at the current position.
     *
     * @param s
     */
    public TexBuilder<T> tex(String s) {
        if (s != null) {
            b.append(s);
        }
        return this;
    }

    public TexBuilder<T> tex(CVNode node) {
        if (node != null) {
            return this.tex(this.printNode(node));
        } else {
            return this;
        }
    }

    public TexBuilder<T> tex(Collection<Object> col, String separator) {
        final var iter = col.iterator();
        while (iter.hasNext()) {
            Object item = iter.next();

            if (item instanceof String) {
                String s = (String) item;
                this.tex(s);
            } else if (item instanceof CVNode) {
                CVNode node = (CVNode) item;
                this.tex(node);
            } else {
                throw new IllegalArgumentException("given collection must either contain Strings or CVNodes");
            }

            if (iter.hasNext()) {
                this.tex(separator);
            }
        }
        return this;
    }

    public TexBuilder<T> texStrings(Collection<String> strings, String separator) {
        final var iter = strings.iterator();
        while (iter.hasNext()) {
            this.tex(iter.next());

            if (separator != null && iter.hasNext()) {
                this.tex(separator);
            }
        }
        return this;
    }

    public TexBuilder<T> texStrings(Collection<String> strings) {
        return this.texStrings(strings, null);
    }

    public TexBuilder<T> texStrings(Map<String, ?> args) {
        final Collection<String> strings = (Collection<String>) args.get("strings");
        final String separator = (String) args.get("separator");
        if (strings != null) {
            return this.texStrings(strings, separator);
        } else {
            return this;
        }
    }

    public TexBuilder<T> texlnStrings(Collection<String> strings, String separator) {
        final var iter = strings.iterator();
        while (iter.hasNext()) {
            this.texln(iter.next());
            if (separator != null && iter.hasNext()) {
                this.texln(separator);
            }
        }
        return this;
    }

    public TexBuilder<T> texlnStrings(Collection<String> strings) {
        return this.texlnStrings(strings, null);
    }

    public TexBuilder<T> texlnStrings(Map<String, ?> args) {
        final Collection<String> strings = (Collection<String>) args.get("strings");
        final String separator = (String) args.get("separator");
        if (strings != null) {
            return this.texlnStrings(strings, separator);
        } else {
            return this;
        }
    }

    public TexBuilder<T> texNodes(Collection<CVNode> nodes, String separator) {
        final var iter = nodes.iterator();
        while (iter.hasNext()) {
            this.tex(iter.next());

            if (separator != null && iter.hasNext()) {
                this.tex(separator);
            }
        }
        return this;
    }

    public TexBuilder<T> texNodes(Collection<CVNode> nodes) {
        return this.texNodes(nodes, null);
    }

    public TexBuilder<T> texNodes(Map<String, ?> args) {
        final Collection<CVNode> nodes =(Collection<CVNode>) args.get("nodes");
        final String separator = (String) args.get("separator");
        if (nodes != null) {
            return this.texNodes(nodes, separator);
        } else {
            return this;
        }
    }

    public TexBuilder<T> texlnNodes(Collection<CVNode> nodes, String separator) {
        final var iter = nodes.iterator();
        while (iter.hasNext()) {
            this.texln(iter.next());
            if (separator != null && iter.hasNext()) {
                this.texln(separator);
            }
        }
        return this;
    }

    public TexBuilder<T> texlnNodes(Collection<CVNode> nodes) {
        return this.texlnNodes(nodes, null);
    }

    public TexBuilder<T> texlnNodes(Map<String, ?> args) {
        final Collection<CVNode> nodes = (Collection<CVNode>) args.get("nodes");
        final String separator = (String) args.get("separator");
        if (nodes != null) {
            return this.texlnNodes(nodes, separator);
        } else {
            return this;
        }
    }

    public TexBuilder<T> plus(String s) {
        return this.tex(s);
    }

    public TexBuilder<T> plus(CVNode node) {
        return this.tex(node);
    }

    public TexBuilder<T> leftShift(String s) {
        return this.tex(s);
    }

    public TexBuilder<T> leftShift(CVNode node) {
        return this.tex(node);
    }

    /**
     * Appends the string at the current position, starting on a new line.
     * @param s
     */
    public TexBuilder<T> texln(String s) {
        if (s != null) {
            if (this.endsWithNewLine()) {
                return this.tex(s);
            } else {
                return this.tex("\n").tex(s);
            }
        } else {
            return this;
        }
    }

    public TexBuilder<T> texln(CVNode node) {
        if (node != null) {
            if (this.endsWithNewLine()) {
                return this.tex(node);
            } else {
                return this.tex("\n").tex(node);
            }
        } else {
            return this;
        }
    }


    public void prependTex(String tex) {
        b.insert(0, tex);
    }


//
//    public void indent() {
//        this.indentAmount++;
//    }
//
//    public void indent(int amount) {
//        this.indentAmount += amount;
//    }
//
//    public void setIndent(int amount) {
//        if (amount < 0) {
//            throw new IllegalArgumentException("indentAmount must be greater than or equal to 0.");
//        }
//        this.indentAmount = amount;
//    }
//
//    public void unindent() {
//        if (this.indentAmount > 0) {
//            this.indentAmount--;
//        }
//    }
//
//    public void unindent(int amount) {
//        if (this.indentAmount - amount >= 0) {
//            this.indentAmount -= amount;
//        } else {
//            this.indentAmount = 0;
//        }
//    }

    public T getItem() {
        return this.item;
    }

    public TexPrintingContext getContext() {
        return this.context;
    }

    public String toString() {
        return this.b.toString();
    }

}
