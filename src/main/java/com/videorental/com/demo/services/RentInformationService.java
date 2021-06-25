package com.videorental.com.demo.services;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.Video;
import org.springframework.stereotype.Service;

@Service
public interface RentInformationService {

    RentInformation getRentByVideo(Video video);
}
