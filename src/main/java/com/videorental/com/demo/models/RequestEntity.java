package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEntity {

    private String name;
    private Long rentDate;
    private Long returnDate;
}
