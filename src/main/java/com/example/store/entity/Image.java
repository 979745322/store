package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private long id;
    private long product_id;
    private String name;
    private String url;
    private String delete_state;
    private String create_time;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", delete_state='" + delete_state + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
