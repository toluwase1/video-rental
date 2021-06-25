package com.videorental.com.demo.services.serviceImplementation;

import com.videorental.com.demo.exception.ResourceNotFoundException;
import com.videorental.com.demo.models.User;
import com.videorental.com.demo.repositories.UserRepository;
import com.videorental.com.demo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    //method lists all created users
    @GetMapping
    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //get User By ID
    @GetMapping("/{id}")
    @Override
    public User getUserById (@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User with ID" + userId +" not found"));
    }

    //create a user
    @PostMapping
    @Override
    public  User addUsers (@RequestBody User user){
        return userRepository.save(user);
    }

    //update User
    @PutMapping("/{id}")
    @Override
    public User updateUser (@RequestBody User user, @PathVariable("id") long userId){
        User existingUser = getUserById(userId);
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());

        return this.userRepository.save(existingUser);

    }

    //delete User
    @DeleteMapping("/{id}")
    @Override
    public void deleteUsers( @PathVariable("id") long userId){
         User user = getUserById(userId);
        this.userRepository.delete(user);
    }

    public User getUserByName(String name) {
        return userRepository.findUserByFirstName(name);
    }
}
