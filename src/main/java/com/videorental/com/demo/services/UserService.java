package com.videorental.com.demo.services;

import com.videorental.com.demo.models.User;
import com.videorental.com.demo.models.Video;

import java.util.List;

public interface UserService {
    List<User> getAllUsers ();
    User addUsers (User user);
    void deleteUsers (long id);
    User getUserById (long id);
    User updateUser (User user, long id);
    User getUserByName(String name);
}
