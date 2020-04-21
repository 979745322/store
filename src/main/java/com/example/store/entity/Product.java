package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Product {
    private long id;
    private String name;
    private BigDecimal commission;
    private BigDecimal price;
    private String introduction;
    private long solid;
    private long shop_id;
    private long inventory;
    private BigDecimal old_price;
    private String delete_state;
    private String tag;
    private String type;
    private String create_time;
    private String state;
    private long[] image;
    private List<Image> imageList;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commission=" + commission +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", solid=" + solid +
                ", shop_id=" + shop_id +
                ", inventory=" + inventory +
                ", old_price=" + old_price +
                ", delete_state='" + delete_state + '\'' +
                ", tag='" + tag + '\'' +
                ", type='" + type + '\'' +
                ", create_time='" + create_time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
