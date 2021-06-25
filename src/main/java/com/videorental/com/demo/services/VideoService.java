package com.videorental.com.demo.services;

import com.videorental.com.demo.models.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideos ();
    Video addVideos (Video video) throws Exception;
    void deleteVideos (long id);
    Video getVideoById (long id);
    Video updateVideos (Video video, long id);
    Page <Video> findPaginated (int pageNumber, int pageSize);
}
