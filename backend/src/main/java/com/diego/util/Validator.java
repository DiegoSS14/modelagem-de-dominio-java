package com.diego.util;

public class Validator {
    private Validator() {}

    public static String notNull(Object object, String errorMessage) {
        return object == null ? errorMessage : null;
    }

    public static String notEmpty(String value, String errorMessage) {
        if (notNull(value, errorMessage) != null)
            return errorMessage;
        return value.trim() == "" ? errorMessage : null;
    }
}
