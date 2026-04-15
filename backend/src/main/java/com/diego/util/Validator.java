package com.diego.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private Validator() {
    }

    public static List<String> combine(String... errors) {
        if (errors.length == 0) {
            return List.of();
        }
        Set<String> finalList = new HashSet<String>();
        for (String error : errors) {
            if (error != null) {
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
        return value.trim().isEmpty() ? errorMessage : null;
    }

    public static String lessThan(Collection<?> value, int minSize, String error) {
        if (notNull(value, error) != null)
            return error;
        return value.toArray().length >= minSize ? null : error;
    }

    public static String lessThan(CharSequence value, int minSize, String error) {
        if (notNull(value, error) != null)
            return error;
        return value.length() >= minSize ? null : error;
    }

    public static String greaterThan(CharSequence value, int maxSize, String error) {
        if (notNull(value, error) != null)
            return error;
        return value.length() <= maxSize ? null : error;
    }

    public static String greaterThan(Collection<?> value, int maxSize, String error) {
        if (notNull(value, error) != null)
            return error;
        return value.toArray().length <= maxSize ? null : error;
    }

    public static String regex(String value, Pattern regex, String error) {
        if (notNull(value, error) != null)
            return error;
        return regex.matcher(value).find() ? null : error;
    }
}
