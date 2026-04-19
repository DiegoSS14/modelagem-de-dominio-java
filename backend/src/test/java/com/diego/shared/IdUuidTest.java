package com.diego.shared;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class IdUuidTest {
    
    @Test
    void deveCriarUmId() {
        IdUuid id = new IdUuid(UUID.randomUUID().toString());
        assertNotNull(id);
    }

    @Test
    void deveCriarUmIdAleatorio() {
        IdUuid id = IdUuid.newUUID();
        assertNotNull(id);
    }

    @Test
    void deveLancarErroAoTentarCriarIdNuloVazioOuInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new IdUuid(null));
        assertThrows(IllegalArgumentException.class, () -> new IdUuid(""));
        assertThrows(IllegalArgumentException.class, () -> new IdUuid("1234"));
    }
}
