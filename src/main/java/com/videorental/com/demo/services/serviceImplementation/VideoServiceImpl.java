package com.videorental.com.demo.services.serviceImplementation;

import com.videorental.com.demo.exception.ResourceNotFoundException;
import com.videorental.com.demo.models.Video;
import com.videorental.com.demo.models.VideoType;
import com.videorental.com.demo.repositories.VideoRepository;
import com.videorental.com.demo.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public List<Video> getAllVideos() {
         return this.videoRepository.findAll();
    }

    //get video By ID
    @Override
    public Video getVideoById (@PathVariable(value = "id") long videoId) {
        return this.videoRepository.findById(videoId).
                orElseThrow(()-> new ResourceNotFoundException("Video with ID" + videoId +" not found"));
    }

    //create a video
    @Override
    public Video addVideos (@RequestBody Video video) throws Exception {
        if(video.getType().equals(VideoType.REGULAR) && (video.getMaxAge() != null || video.getYearRelease() != null)){
           throw  new  Exception("Bad Request, Year of release or max age is not null");
        }
        if(video.getType().equals(VideoType.CHILDREN_MOVIE) && video.getYearRelease() != null){
            throw  new  Exception("Bad Request, Year of release is not null");
        }

        if(video.getType().equals(VideoType.NEW_RELEASE) && video.getMaxAge() != null){
            throw  new  Exception("Bad Request, max age is not null");
        }
       return videoRepository.save(video);
    }


    //update video
    @PutMapping("/{id}")
    @Override
    public Video updateVideos (@RequestBody Video video, @PathVariable("id") long videoId){
        Video existingVideo = getVideoById(videoId);
        existingVideo.setVideoTitle(video.getVideoTitle());
        return this.videoRepository.save(video);
    }


    @DeleteMapping("/{id}")
    @Override
    public void deleteVideos( @PathVariable("id") long videoId){
        var existingVideo = getVideoById(videoId);
        this.videoRepository.delete(existingVideo);
    }

    @Override
    public Page<Video> findPaginated(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
       return videoRepository.findAll(pageable);
    }


}
