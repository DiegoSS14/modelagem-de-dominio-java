package com.diego.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void deveCriarUmEmailValido() {
        Email email = new Email("diego123@gmail.com");
        assertAll(
                () -> assertEquals("diego123", email.local()),
                () -> assertEquals("gmail.com", email.domain()),
                () -> assertEquals("diego123@gmail.com", email.value()));
    }

    @Test
    void deveFalharAoCriarUmEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email("gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }
}
