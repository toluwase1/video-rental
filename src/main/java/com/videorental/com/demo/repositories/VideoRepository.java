package com.videorental.com.demo.repositories;

import com.videorental.com.demo.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
