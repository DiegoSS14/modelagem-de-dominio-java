package com.diego.anemico.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void deveCriarUmUsuarioSemArgumentos() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
    }

    @Test 
    void deveDefinirOsAtributosComSetters() {
        User user = new User();
        user.setId("1");
        user.setName("Diego");
        user.setEmail("diego@gmail.com");
        user.setPassword("abcdefgh");
        
        assertEquals("1", user.getId());
        assertEquals("Diego", user.getName());
        assertEquals("diego@gmail.com", user.getEmail());
        assertEquals("abcdefgh", user.getPassword());
    }

    @Test 
    void deveCompararDoisUsuariosIguais(){
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        User user2 = new User("1", "Diego", "diego@gmail.com", "12345678");
        
        assertTrue(user.equals(user2));
        assertEquals(user, user2);
        assertEquals(user.hashCode(), user2.hashCode());
    }

    @Test
    void deveRetornarFalseParaNullEOutroTipo() {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");

        assertFalse(user.equals(null));
        assertFalse(user.equals(new Object()));
    }

    @Test 
    void deveRetornarFalseQuandoCamposDiferem(){
        User user1 = new User("1", "Diego", "diego@gmail.com", "12345678");
        User user2 = new User("2", "Diego", "diego@gmail.com", "12345678");
        User user3 = new User("1", "Maria", "diego@gmail.com", "12345678");
        User user4 = new User("1", "Diego", "maria@gmail.com", "12345678");
        User user5 = new User("1", "Diego", "diego@gmail.com", "87654321");

        assertNotEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user1, user4);
        assertNotEquals(user1, user5);
    }

    @Test
    void deveVerificarCamposNulosEmLadosDiferentes() {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        User userIdNulo = new User(null, "Diego", "diego@gmail.com", "12345678");
        User userNameNulo = new User("1", null, "diego@gmail.com", "12345678");
        User userEmailNulo = new User("1", "Diego", null, "12345678");
        User userPasswordNulo = new User("1", "Diego", "diego@gmail.com", null);

        assertNotEquals(user, userIdNulo);
        assertNotEquals(user, userNameNulo);
        assertNotEquals(user, userEmailNulo);
        assertNotEquals(user, userPasswordNulo);
    }

    @Test
    void deveCompararDoisUsuariosComTodosCamposNulos() {
        User user = new User(null, null, null, null);
        User user2 = new User(null, null, null, null);

        assertEquals(user, user2);
        assertEquals(user.hashCode(), user2.hashCode());
    }
    
    @Test
    void deveRetornarOUsuarioEmFormaDeString() {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        String userString = "User(id=1, name=Diego, email=diego@gmail.com, password=12345678)";
        assertEquals(user.toString(), userString);
    }
}
