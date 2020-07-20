package com.example.datastructure.utility;

public final class StringsUtility {
    public static boolean isEmpty(final String text) {
        return text == null || text.length() == 0;
    }
    public static boolean hasText(final String text) {
        return text != null && text.trim().length() > 0;
    }

}
