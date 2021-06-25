package com.videorental.com.demo.services.serviceImplementation;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.Video;
import com.videorental.com.demo.repositories.RentRepository;
import com.videorental.com.demo.services.RentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentInformServImpl implements RentInformationService {
    @Autowired
    RentRepository rentRepository;

    @Override
    public RentInformation getRentByVideo(Video video) {
        return rentRepository.findByVideo(video);
    }
}
