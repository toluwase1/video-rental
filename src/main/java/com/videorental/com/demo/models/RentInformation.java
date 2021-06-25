package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rent_info")
public class RentInformation{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @OneToOne
    private Video video;

    @ManyToOne
    private User user;

    @Column(name = ("rent_date"))
    private Long rentDate;

    @Column(name = "return_date")
    private Long returnDate;

}
