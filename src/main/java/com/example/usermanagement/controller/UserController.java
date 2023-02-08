package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
public class UserController {
        private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/getUser/userId/{userId}")
    public User findUserById(@PathVariable int userId){
        return userService.findById(userId);
    }

    @GetMapping("/getAllUser")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @PutMapping("/updateUserInfo/userId/{userId}")
    public void upadateUser(@PathVariable int userId, @RequestBody User user){

    }
    @DeleteMapping("/deleteUser/userId/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }
}



