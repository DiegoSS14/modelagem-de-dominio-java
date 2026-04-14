package com.diego;

import com.diego.anemico.user.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("1", "Diego", "diego@gmail.com", "12345678");
        System.out.println(user);
    }
}