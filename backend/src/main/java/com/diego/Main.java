package com.diego;

import com.diego.user.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("123", "DIego", "diego@gmail.com", "123456789");
        System.out.println(user);
    }
}