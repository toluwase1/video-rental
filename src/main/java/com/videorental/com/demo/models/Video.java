package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Video extends BaseModel {


    @Column(name = "video_type")
    @Enumerated(EnumType.STRING)
    private VideoType type;

    @Column(name = "max_age")
    private Long maxAge;

    @Column(name = "year_released")
    private Long yearRelease;

    public Video() {
    }


//    @OneToOne
//    private VideoType videoType;
//
//    @OneToOne
//    private VideoGenre videoGenre;
}

//draw your conceptual and logical model
//price endpoint
//swagger
//enums on endpoint
//spring security
