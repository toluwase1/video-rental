package com.videorental.com.demo.endpoints;

import com.videorental.com.demo.models.Video;
import com.videorental.com.demo.services.serviceImplementation.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoEndpoint {
    @Autowired
    private VideoServiceImpl videoService;

    //method lists all created video
    @GetMapping("/all")
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.status(HttpStatus.OK).body(videos);
    }

    //get video By ID
    @GetMapping("/{id}")
    public Video getVideoById (@PathVariable(value = "id") long videoId) {
        return this.videoService.getVideoById(videoId);
    }

    //create a video
    @PostMapping("add")
    public ResponseEntity<?> createVideos (@RequestBody Video video) throws Exception {
        videoService.addVideos(video);
        return ResponseEntity.status(HttpStatus.OK).body(video);
    }


    //update video
    @PutMapping("/{id}")
    public  Video updateVideos (@RequestBody Video video, @PathVariable("id") long videoId){
        return videoService.updateVideos(video, videoId);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deleteVideos(@RequestBody Video video, @PathVariable("id") long videoId){
        this.videoService.deleteVideos(videoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paginated/{id}")
    public ResponseEntity<List<Video>> getByPagination(@PathVariable("id") int pageNo) {
        int pageSize = 5;
        Page<Video> videoPage = videoService.findPaginated(pageNo, pageSize);
        List<Video> videos = videoPage.getContent();
        return ResponseEntity.status(HttpStatus.OK).body(videos);
    }


}
