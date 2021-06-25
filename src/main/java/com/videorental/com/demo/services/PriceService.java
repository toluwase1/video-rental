package com.videorental.com.demo.services;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.RequestEntity;
import com.videorental.com.demo.models.Video;

public interface PriceService {
    Double calculateRegularPrice (RequestEntity req);
    Double calculateChildrenPrice (Video video,RequestEntity req);
    Double calculateNewReleasePrice (Video video, RequestEntity req);
    Double calculatePrice(Video video, RequestEntity req);
}
