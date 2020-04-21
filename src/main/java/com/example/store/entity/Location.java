package com.example.store.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private long id;
    private long user_id;
    private String save_date;
    private String location_default;
    private String name;
    private String tel;
    private String province;
    private String city;
    private String region;
    private String address;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", save_date='" + save_date + '\'' +
                ", location_default='" + location_default + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
