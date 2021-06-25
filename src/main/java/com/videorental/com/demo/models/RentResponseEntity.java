package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentResponseEntity {
    private String name;
    private String title;
    private Long duration;
    private Double price;

    public RentResponseEntity(String name, String title, Long duration, Double price) {
        this.name = name;
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    public RentResponseEntity() {
    }
}
