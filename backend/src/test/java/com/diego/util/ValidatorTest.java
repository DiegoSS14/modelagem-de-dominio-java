package com.diego.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

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
    @Test
    void deveRetornarUmaListaNulaDeErros() {
        List<String> errors = Validator.combine();
        assertEquals(Collections.emptyList(), errors);
    }

    @Test
    void deveRetornarUmaListaVaziaDeErros() {
        List<String> errors = Validator.combine();
        assertEquals(Collections.emptyList(), errors);
    }

    @Test
    void testGreaterThan() {
        String texto = "abcde";
        assertEquals(Validator.greaterThan(texto, 5, GENERIC_ERROR), null);
    }
    
    @Test
    void testGreaterThan2() {
        CharSequence texto = "abcde";
        assertEquals(Validator.greaterThan(texto, 5, GENERIC_ERROR), null);
    }

    @Test
    void deveRetornarErroNoGreaterThanQuandoTextoUltrapassaOTamanhoMaximo() {
        String texto = "abcdef";
        assertEquals(GENERIC_ERROR, Validator.greaterThan(texto, 5, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoGreaterThanQuandoCharSequenceUltrapassaOTamanhoMaximo() {
        CharSequence texto = "abcde";
        assertEquals(GENERIC_ERROR, Validator.greaterThan(texto, 4, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoGreaterThanQuandoCharSequenceForNula() {
        assertEquals(GENERIC_ERROR, Validator.greaterThan((CharSequence) null, 5, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoGreaterThanComCollectionQuandoForNula() {
        assertEquals(GENERIC_ERROR, Validator.greaterThan((List<?>) null, 3, GENERIC_ERROR));
    }
    
    @Test
    void testLessThan() {
        CharSequence texto = "abcdef";
        assertEquals(Validator.lessThan(texto, 5, GENERIC_ERROR), null);
    }
    
    @Test
    void testLessThan2() {
        String texto = "abcdef";
        assertEquals(Validator.lessThan(texto, 5, GENERIC_ERROR), null);
    }

    @Test
    void deveRetornarErroNoLessThanQuandoTextoForMenorQueOTamanhoMinimo() {
        String texto = "abcd";
        assertEquals(GENERIC_ERROR, Validator.lessThan(texto, 5, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoLessThanQuandoCharSequenceForMenorQueOTamanhoMinimo() {
        CharSequence texto = "abc";
        assertEquals(GENERIC_ERROR, Validator.lessThan(texto, 4, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoLessThanQuandoCharSequenceForNula() {
        assertEquals(GENERIC_ERROR, Validator.lessThan((CharSequence) null, 5, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoLessThanComCollectionQuandoForNula() {
        assertEquals(GENERIC_ERROR, Validator.lessThan((List<?>) null, 3, GENERIC_ERROR));
    }

    @Test
    void deveValidarLessThanComCollectionQuandoAtingeOTamanhoMinimo() {
        List<Integer> valores = List.of(1, 2, 3);
        assertNull(Validator.lessThan(valores, 3, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoLessThanComCollectionQuandoNaoAtingeOTamanhoMinimo() {
        List<Integer> valores = List.of(1, 2);
        assertEquals(GENERIC_ERROR, Validator.lessThan(valores, 3, GENERIC_ERROR));
    }

    @Test
    void deveValidarGreaterThanComCollectionQuandoRespeitaOTamanhoMaximo() {
        List<Integer> valores = List.of(1, 2, 3);
        assertNull(Validator.greaterThan(valores, 3, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoGreaterThanComCollectionQuandoUltrapassaOTamanhoMaximo() {
        List<Integer> valores = List.of(1, 2, 3, 4);
        assertEquals(GENERIC_ERROR, Validator.greaterThan(valores, 3, GENERIC_ERROR));
    }

    @Test
    void deveValidarUmTextoRegex() {
        Pattern regex = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9$!@#%&*()]{8,}$");
        assertNull(Validator.regex("abcdefg1234", regex, GENERIC_ERROR));
    }
    
    @Test
    void deveInvalidarUmTextoAPartirDoRegex() {
        Pattern regex = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9$!@#%&*()]{8,}$");
        assertEquals(GENERIC_ERROR, Validator.regex("abde", regex, GENERIC_ERROR));
    }
    @Test
    void deveInvalidarUmTextoAPartirDoRegexAoReceberTextoNulo() {
        Pattern regex = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9$!@#%&*()]{8,}$");
        assertEquals(GENERIC_ERROR, Validator.regex(null, regex, GENERIC_ERROR));
    }

    @Test
    void deveRetornarErroNoNotEmptyQuandoCharSequenceForNule() {
        assertEquals(GENERIC_ERROR, Validator.notEmpty(null, GENERIC_ERROR));
    }
}
