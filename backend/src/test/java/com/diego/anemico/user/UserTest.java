package com.diego.anemico.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void deveCriarUmUsuarioCorretamente() {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        assertEquals("1", user.getId());
        assertEquals("Diego", user.getName());
        assertEquals("diego@gmail.com", user.getEmail());
        assertEquals("12345678", user.getPassword());
    }

    @Test
    void deveCriarUmUsuarioComTodosOsCamposVazios() {
        User user = new User(" ", " ", " ", " ");
        assertEquals(" ", user.getId());
        assertEquals(" ", user.getName());
        assertEquals(" ", user.getEmail());
        assertEquals(" ", user.getPassword());
    }

    @Test
    void deveCriarUmUsuarioNulo() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
    }
}
