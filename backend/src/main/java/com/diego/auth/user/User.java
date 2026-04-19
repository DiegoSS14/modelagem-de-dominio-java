package com.diego.auth.user;

import java.time.Instant;

import com.diego.shared.Email;
import com.diego.shared.Entity;
import com.diego.shared.IdUuid;
import com.diego.shared.Name;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Entity<IdUuid>{
    private Name name;
    private Email email;
    private Instant registrationDate;

    public User(IdUuid id, Name name, Email email, Instant registrationDate) {
        super(id);
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
