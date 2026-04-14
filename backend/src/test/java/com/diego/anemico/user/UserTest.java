package com.diego.anemico.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    
    @Test 
    void devecriarUmUsuarioVazioEDefinirOsAtributosComSetters() {
        User user = new User();
        user.setId("1");
        user.setName("Diego");
        user.setEmail("diego@gmail.com");
        user.setPassword("abcdefgh");
        
        assertNotNull(user);
    }
    
    @Test 
    void deveCompararDoisUsuariosDiferentes(){
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        User user2 = new User("2", "Diego", "diego@gmail.com", "12345678");
        assertNotEquals(user, user2);
    }

    @Test 
    void deveCompararDoisUsuariosIguaisEmEquals(){
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        assertTrue(user.canEqual(user));
    }

    @Test 
    void deveCompararDoisUsuariosIguais(){
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        User user2 = new User("1", "Diego", "diego@gmail.com", "12345678");
        assertEquals(user, user2);
    }

    @Test 
    void deveCompararOHashcodeDoObjeto(){
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        User user2 = new User("1", "Diego", "diego@gmail.com", "12345678");
        assertEquals(user.hashCode(), user2.hashCode());
    }
    
    @Test
    void deveRetornarOUsuarioEmFormaDeString() {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        String userString = "User(id=1, name=Diego, email=diego@gmail.com, password=12345678)";
        assertEquals(user.toString(), userString);
    }
}
