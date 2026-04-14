package com.diego.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private final String GENERIC_ERROR = "Erro genérico";
    
    @Test
    void deveValidarUmValorNaoNulo() {
        assertNull(Validator.notNull(123, null));
        assertNull(Validator.notNull("abc", null));
        assertNull(Validator.notNull('A', null));
    }

    @Test
    void deveValidarUmValorNaoVazio() {
        assertNull(Validator.notEmpty("ABC", null));
    }

    @Test
    void deveRetornarErroAoReceberUmValorNulo() {
        assertEquals(Validator.notEmpty(null, GENERIC_ERROR), GENERIC_ERROR);
    }

    @Test
    void deveRetornarErroAoReceberUmValorVazio() {
        assertEquals(Validator.notEmpty(" ", GENERIC_ERROR), GENERIC_ERROR);
    }

    @Test
    void deveCombinarOsErrosEmUmaLista() {
        List<String> errors = Validator.combine(
            Validator.notEmpty("", "Erro 1"),
            Validator.notEmpty(null, "Erro 2"),
            Validator.notNull("abc", "Erro 3"),
            Validator.notEmpty("", "Erro 4")
        );
        assertEquals(errors, List.of("Erro 1", "Erro 4", "Erro 2"));
    }
}
