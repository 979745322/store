package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private long id;
    private String username;
    private String password;
    private String token;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
