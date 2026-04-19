package com.diego.shared;

import java.time.Instant;
import java.util.List;

import com.diego.util.Validator;

public record PastDate(Instant value) {
    public static String DATE_NULL = "Field is null";
    public static String DATE_EMPTY = "Field is empty";
    public static String DATE_FUTURE = "Field is in the future";

    public PastDate {
        String isNull = Validator.notNull(value, DATE_NULL);

        if (isNull != null) {
            throw new IllegalArgumentException(isNull);
        }

        List<String> errors = Validator.combine(
            value.isAfter(Instant.now()) ? DATE_FUTURE : null
        );

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(",", errors));
        }
    }

    public static PastDate now() {
        return new PastDate(Instant.now());
    }
}
