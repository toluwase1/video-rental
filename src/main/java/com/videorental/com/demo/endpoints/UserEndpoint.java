package com.videorental.com.demo.endpoints;

import com.videorental.com.demo.models.User;
import com.videorental.com.demo.services.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/users")
public class UserEndpoint {
    @Autowired
    private UserServiceImpl userService;

    //method lists all created users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //get User By ID
    @GetMapping("/{id}")
    public User getUserById (@PathVariable (value = "id") long userId) {
        return userService.getUserById(userId);
    }

    //create a user
    @PostMapping("add")
    public  User createUser (@RequestBody User user){
        return userService.addUsers(user);
    }

    //update User
    @PutMapping("/{id}")
    public  User updateUser (@RequestBody User user, @PathVariable("id") long userId){
        return userService.updateUser(user, userId);

    }

    //deletes user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
            userService.deleteUsers(userId);
         return ResponseEntity.status(HttpStatus.OK).body("User with "+ userId +" deleted");
    }


}
