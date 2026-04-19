package com.diego.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;

import org.junit.jupiter.api.Test;

public class PastDateTest {
    
    @Test
    void deveCriarUmaNovaData() {
        Instant dataAtual = Instant.now();
        PastDate date = new PastDate(dataAtual);
        assertEquals(dataAtual, date.value());
    }
    
    @Test
    void deveCriarUmaNovaDataAPartirDoMetodoEstatico() {
        PastDate date = PastDate.now();

        assertNotNull(date);
        assertFalse(date.value().isAfter(Instant.now()));
    }

    @Test
    void deveRetornarErroAoCriarDataNula() {
        assertThrows(IllegalArgumentException.class, () -> new PastDate(null));
    }

    @Test
    void deveRetornarErroAoCriarDataFutura() {
        assertThrows(IllegalArgumentException.class, () -> new PastDate(Instant.now().plusSeconds(60)));
    }

    @Test
    void deveCriarUmaDataNoPassado() {
        PastDate date = new PastDate(Instant.now().minusSeconds(60));
        assertNotNull(date);
    }
}
