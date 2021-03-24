package com.brault.jgtcv.api.tex;

import java.util.HashMap;
import java.util.Map;

public final class TexPrinterUtils {

    private static final Map<String, String> diacriticReplacements = new HashMap<>();

    static {
        diacriticReplacements.put("á", "\\'a");
        diacriticReplacements.put("é", "\\'e");
        diacriticReplacements.put("í", "\\'i");
        diacriticReplacements.put("ó", "\\'o");
        diacriticReplacements.put("ú", "\\'u");

        diacriticReplacements.put("Á", "\\'A");
        diacriticReplacements.put("É", "\\'E");
        diacriticReplacements.put("Í", "\\'I");
        diacriticReplacements.put("Ó", "\\'O");
        diacriticReplacements.put("Ú", "\\'U");

        diacriticReplacements.put("à", "\\`a");
        diacriticReplacements.put("è", "\\`e");
        diacriticReplacements.put("ì", "\\`i");
        diacriticReplacements.put("ò", "\\`o");
        diacriticReplacements.put("ù", "\\`u");

        diacriticReplacements.put("À", "\\`A");
        diacriticReplacements.put("È", "\\`E");
        diacriticReplacements.put("Ì", "\\`I");
        diacriticReplacements.put("Ò", "\\`O");
        diacriticReplacements.put("Ù", "\\`U");

        diacriticReplacements.put("â", "\\^a");
        diacriticReplacements.put("ê", "\\^e");
        diacriticReplacements.put("î", "\\^i");
        diacriticReplacements.put("ô", "\\^o");
        diacriticReplacements.put("û", "\\^u");

        diacriticReplacements.put("Â", "\\^A");
        diacriticReplacements.put("Ê", "\\^E");
        diacriticReplacements.put("Î", "\\^I");
        diacriticReplacements.put("Ô", "\\^O");
        diacriticReplacements.put("Û", "\\^U");

        diacriticReplacements.put("ä", "\\\"a");
        diacriticReplacements.put("ë", "\\\"e");
        diacriticReplacements.put("ï", "\\\"i");
        diacriticReplacements.put("ö", "\\\"o");
        diacriticReplacements.put("ü", "\\\"u");

        diacriticReplacements.put("Ä", "\\\"A");
        diacriticReplacements.put("Ë", "\\\"E");
        diacriticReplacements.put("Ï", "\\\"I");
        diacriticReplacements.put("Ö", "\\\"O");
        diacriticReplacements.put("Ü", "\\\"U");

        diacriticReplacements.put("ñ", "\\~n");
        diacriticReplacements.put("Ñ", "\\~N");

        diacriticReplacements.put("ř", "\\v r");
        diacriticReplacements.put("Ř", "\\v R");

        // TODO: tilde, umlaut, etc
    }

    /**
     * Replaces any character with diacritics with TeX-friendly equivalents.
     *
     * @param s the string to process
     * @return a TeX-friendly string
     */
    public static String transformDiacritics(String s) {
        final var b = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            final var c = s.substring(i, i + 1);
            if (diacriticReplacements.containsKey(c)) {
                b.append(diacriticReplacements.get(c));
            } else {
                b.append(c);
            }
        }
        return b.toString();
    }

    /**
     * Produces a TeX bullet point.
     */
    public static String bullet() {
        return "$\\bullet$";
    }

}
