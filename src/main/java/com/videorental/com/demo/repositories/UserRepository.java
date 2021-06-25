package com.videorental.com.demo.repositories;

import com.videorental.com.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByFirstName(String name);
}
