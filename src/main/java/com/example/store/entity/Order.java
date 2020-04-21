package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Order {
    private long id;
    private String order_id;
    private long user_id;
    private String promoter;
    private BigDecimal commission;
    private long num;
    private BigDecimal total_price;
    private long product_id;
    private long location_id;
    private String create_time;
    private String state;
    private String delete_state;
    private Product product;
    private Location location;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", user_id=" + user_id +
                ", promoter='" + promoter + '\'' +
                ", commission=" + commission +
                ", num=" + num +
                ", total_price=" + total_price +
                ", product_id=" + product_id +
                ", location_id=" + location_id +
                ", create_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                ", delete_state='" + delete_state + '\'' +
                '}';
    }
}
