package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {
    private long id;
    private String wechat_id;
    private String tel;
    private BigDecimal commission;
    private String create_time;
    private String state;
    private String delete_state;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", wechat_id='" + wechat_id + '\'' +
                ", tel='" + tel + '\'' +
                ", commission=" + commission +
                ", creat_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                ", delete_state='" + delete_state + '\'' +
                '}';
    }
}
