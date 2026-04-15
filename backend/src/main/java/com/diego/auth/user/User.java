package com.diego.auth.user;

import java.time.Instant;

import com.diego.shared.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String name;
    private Email email;
    private Instant registrationDate;
}
