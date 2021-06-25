package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel {
    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private Long phoneNumber;

    public User(String firstName, String lastName, String email, String password, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(String password, Long phoneNumber) {
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }
    //integer(Object)

    // int(primitive), long, String, float, ,
    //int minimum (-2147483648)
    //max (2147483647)
}
