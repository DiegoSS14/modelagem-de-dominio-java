package com.diego.shared;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import com.diego.util.Validator;

public record Email(String value) {
    public static final String ERROR_NULL = "Email is null";
    public static final String ERROR_EMPTY = "Email is empty";
    public static final String ERROR_LESS_THAN = "Email less";
    public static final String ERROR_GREATER_THAN = "Email is greater";
    public static final String ERROR_INVALID = "Email is not valid";

    public static final Pattern regex = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            Pattern.CASE_INSENSITIVE);

    public Email {
        value = (value == null) ? null : value.trim().toLowerCase(Locale.ROOT);

        if (Validator.notNull(value, ERROR_NULL) != null) {
            throw new IllegalArgumentException(ERROR_NULL);
        }

        List<String> errors = Validator.combine(
            Validator.notEmpty(value, ERROR_EMPTY),
            Validator.lessThan(value, 5, ERROR_LESS_THAN),
            Validator.greaterThan(value, 60, ERROR_GREATER_THAN),
            Validator.regex(value, regex, ERROR_INVALID));

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(",", errors));
        }
    }

    public String domain() {
        return this.extractDomain(value);
    }

    public String local() {
        return this.extractLocal(value);
    }

    private String extractLocal(String value) {
        String local = value.split("@")[0];
        return local;
    }

    private String extractDomain(String value) {
        String domain = value.split("@")[1];
        return domain;
    }
}
