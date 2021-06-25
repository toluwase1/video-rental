package com.videorental.com.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table (name = "manager")
public class Manager extends BaseModel {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager() {
    }
}
