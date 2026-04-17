package com.diego.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    void deveCriarUmNomeValido() {
        Name name = new Name("Diego Sousa");
        assertEquals(name.firstName(), "Diego");
        assertEquals(name.lastName(), "Sousa");
        assertEquals(name.fullName(), "Diego Sousa");
    }
    
    @Test
    void deveLancarErrosAoCriarNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Name(null));
        assertThrows(IllegalArgumentException.class, () -> new Name(""));
        assertThrows(IllegalArgumentException.class, () -> new Name("dksandnsaaaaassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssldmksadnsajndjandjabdijadugbsdbakdnksandknbaskjdsaknbdkandjsnajkdnskandkmandskand,an,dam"));
    }
    
    @Test
    void deveRetornarVazioAoBuscarSobrenomeQuandoNaoExiste() {
        Name name = new Name("Diego");
        assertEquals("", name.lastName());
    }
}
