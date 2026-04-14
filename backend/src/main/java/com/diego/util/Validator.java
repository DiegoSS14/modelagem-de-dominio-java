package com.diego.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private Validator() {}

    public static List<String> combine(String... errors) {
        if (errors == null || errors.length == 0) {
            return List.of();
        }
        Set<String> finalList = new HashSet<String>();
        for(String error: errors) {
            if (error != null && !error.isBlank()) {
                finalList.add(error);
            }
        }
        return List.copyOf(finalList);
    }

    public static String notNull(Object object, String errorMessage) {
        return object == null ? errorMessage : null;
    }

    public static String notEmpty(String value, String errorMessage) {
        if (notNull(value, errorMessage) != null)
            return errorMessage;
        return value.trim() == "" ? errorMessage : null;
    }
}
