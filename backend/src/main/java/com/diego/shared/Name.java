package com.diego.shared;

import java.util.Arrays;
import java.util.List;

import com.diego.util.Validator;

public record Name(String value) {
    public static final String ERROR_NULL = "Name is null";
    public static final String ERROR_EMPTY = "Name is empty";
    public static final String ERROR_LESS_THAN = "Name is small";
    public static final String ERROR_GREATER_THAN = "Name is long";

    public Name {
        String isNull = Validator.notNull(value, ERROR_NULL);
        if (isNull != null) {
            throw new IllegalArgumentException(ERROR_NULL);
        }

        List<String> errors = Validator.combine(
                Validator.lessThan(value, 4, ERROR_LESS_THAN),
                Validator.greaterThan(value, 40, ERROR_GREATER_THAN),
                Validator.notEmpty(value, ERROR_EMPTY));

        if (errors.size() > 0) {
            throw new IllegalArgumentException(String.join(",", errors));
        }
    }

    public String firstName() {
        return value.trim().split("\\s+")[0];
    }

    public String lastName() {
        String[] parts = value.trim().split("\\s+");
        return parts.length > 1
                ? String.join(" ", Arrays.copyOfRange(parts, 1, parts.length))
                : "";
    }

    public String fullName() {
        return value;
    }
}
