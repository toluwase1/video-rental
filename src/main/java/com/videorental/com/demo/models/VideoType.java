package com.videorental.com.demo.models;


import java.util.Date;

public enum VideoType{
           REGULAR(10.0),
           CHILDREN_MOVIE(8.0),
           NEW_RELEASE(15.0)
    ;

           private Double dailyRentalRate;

    VideoType(Double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }

    public Double getDailyRentalRate() {
        return dailyRentalRate;
    }

    public void setDailyRentalRate(Double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }
}


// JPA has pagination
// Sorting
//

