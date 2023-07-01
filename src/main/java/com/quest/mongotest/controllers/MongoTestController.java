package com.quest.mongotest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.mongotest.entities.User;
import com.quest.mongotest.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MongoTestController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        log.info("Get all user started");
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        log.info("Craere user started");
        return userService.createUser(user);   
    }
}
