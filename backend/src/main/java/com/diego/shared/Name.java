package com.diego.shared;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.diego.util.Validator;

public record Name(String value) {
    public static final String ERROR_NULL = "Name is null";
    public static final String ERROR_EMPTY = "Name is empty";
    public static final String ERROR_LESS_THAN = "Name is small";
    public static final String ERROR_GREATER_THAN = "Name is long";
    public static final String NO_LAST_NAME = "No last name";
    public static final String INVALID_CHARACTERS = "Invalid characters";

    private static final Pattern REGEX = Pattern.compile("^[a-zA-ZÀ-ÿ\\s]+$");

    public Name {
        if (value == null) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
        value = value.trim().replaceAll("\\s+", " ");

        String lastNameValue = extractLastName(value);

        List<String> errors = Validator.combine(
                Validator.regex(value, REGEX, INVALID_CHARACTERS),
                Validator.lessThan(lastNameValue, 4, NO_LAST_NAME),
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
        return extractLastName(value);
    }

    public String fullName() {
        return value;
    }

    private static String extractLastName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        return parts.length > 1
                ? String.join(" ", Arrays.copyOfRange(parts, 1, parts.length))
                : "";
    }
}
