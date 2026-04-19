package com.diego.shared;

import java.util.List;
import java.util.UUID;

import com.diego.util.Validator;

public record IdUuid(String value) implements Id<String> {

    public IdUuid {
        List<String> errors = Validator.combine(
            Validator.notNull(value, Id.NULL_ID),
            Validator.notEmpty(value, Id.EMPTY_ID)
        );
        
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(",", errors));
        }

        try{
            UUID.fromString(value);
        } catch(Exception error) {
            throw new IllegalArgumentException(error.getMessage());
        }

    }

    public String value() {
        return value;
    }

    public static IdUuid newUUID() {
        return new IdUuid(UUID.randomUUID().toString());
    }
}
