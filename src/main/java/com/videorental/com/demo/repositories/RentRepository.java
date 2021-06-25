package com.videorental.com.demo.repositories;

import com.videorental.com.demo.models.RentInformation;
import com.videorental.com.demo.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentInformation, Long> {
    RentInformation findByVideo(Video video);
}
