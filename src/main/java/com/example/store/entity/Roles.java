package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Roles {
    private long id;
    private String roles;
    private String introduction;
    private String avatar;
    private String name;

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roles='" + roles + '\'' +
                ", introduction='" + introduction + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
