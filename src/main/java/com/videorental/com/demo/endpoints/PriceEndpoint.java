package com.videorental.com.demo.endpoints;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.RentResponseEntity;
import com.videorental.com.demo.models.RequestEntity;
import com.videorental.com.demo.models.User;
import com.videorental.com.demo.models.Video;
import com.videorental.com.demo.models.VideoType;
import com.videorental.com.demo.services.RentInformationService;
import com.videorental.com.demo.services.serviceImplementation.PriceServiceImpl;
import com.videorental.com.demo.services.serviceImplementation.RentInformServImpl;
import com.videorental.com.demo.services.serviceImplementation.UserServiceImpl;
import com.videorental.com.demo.services.serviceImplementation.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/price")
public class PriceEndpoint {

    @Autowired
    private PriceServiceImpl priceService;

    @Autowired
    private VideoServiceImpl videoService;

    @Autowired
    private RentInformServImpl rentInformServ;

    @Autowired
    private UserServiceImpl userService;



    @GetMapping("/{id}")
    public ResponseEntity<RentResponseEntity> calculatePrice(@PathVariable("id") Long id, @RequestBody RequestEntity req) throws UserPrincipalNotFoundException {
        Video video =videoService.getVideoById(id);
        String title = video.getVideoTitle();
        User user = userService.getUserByName(req.getName());
        if(user == null){
            throw new UserPrincipalNotFoundException("User does not exist ");
        }
        Double videoPrice = priceService.calculatePrice(video, req);

        RentResponseEntity resp = new RentResponseEntity();
        resp.setPrice(videoPrice);
        resp.setDuration(req.getReturnDate() - req.getRentDate());
        resp.setName(user.getFirstName() +" " +user.getLastName());
        resp.setTitle(title);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
