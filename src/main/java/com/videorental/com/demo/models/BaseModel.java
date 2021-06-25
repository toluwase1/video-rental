package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_genre")
    @Enumerated(EnumType.STRING)
    private VideoGenre genre;
}
