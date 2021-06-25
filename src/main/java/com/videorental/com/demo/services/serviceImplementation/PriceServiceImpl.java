package com.videorental.com.demo.services.serviceImplementation;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.RequestEntity;
import com.videorental.com.demo.models.Video;
import com.videorental.com.demo.models.VideoType;
import com.videorental.com.demo.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class PriceServiceImpl implements PriceService {

    /**
     * formatting LocalDate to obtain days
     */
//    LocalDate d1 = LocalDate.parse(rentInformation.getRentDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
//    LocalDate d2 = LocalDate.parse(rentInformation.getReturnDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
//
//    LocalDate d3 = LocalDate.parse(rentInformation.getRentDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
//    LocalDate d4 = LocalDate.parse(rentInformation.getReturnDate().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
//
//    Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
//    Period period = Period.between(d3, d4);

//    long rentDuration = diff.toDays();
//    int years = Math.abs(period.getYears());
//    int months = Math.abs(period.getMonths());
//    int days = Math.abs(period.getDays());
    int year = LocalDate.now().getYear();

    @Override
    public Double calculateRegularPrice(RequestEntity req) {
        Double rate = VideoType.REGULAR.getDailyRentalRate();
        Long rentDuration = req.getReturnDate() - req.getRentDate();
        return rentDuration * rate;

    }

    @Override
    public Double calculateChildrenPrice(Video video, RequestEntity req) {
        Double rate = VideoType.CHILDREN_MOVIE.getDailyRentalRate();
        Long rentDuration = req.getReturnDate() - req.getRentDate();

        return (rentDuration * rate)+ (video.getMaxAge()/2);
    }

    @Override
    public Double calculateNewReleasePrice(Video video, RequestEntity req) {
        Double rate = VideoType.NEW_RELEASE.getDailyRentalRate();
        Long rentDuration = req.getReturnDate() - req.getRentDate();
        return (rentDuration * rate)-(year-video.getYearRelease());
    }

    @Override
    public Double calculatePrice (Video video, RequestEntity req) {
        if (video.getType()== VideoType.CHILDREN_MOVIE) {
            return calculateChildrenPrice(video, req);
        } else if (video.getType()==VideoType.NEW_RELEASE) {
            return calculateNewReleasePrice(video, req);
        } else {
            return calculateRegularPrice(req);
        }
    }
}
