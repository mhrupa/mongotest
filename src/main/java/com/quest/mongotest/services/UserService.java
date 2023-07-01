package com.quest.mongotest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.mongotest.entities.User;
import com.quest.mongotest.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        log.info("In get All user service.");  
        return userRepository.findAll();
    }

    public User createUser(User user) {
        log.info("Craere user in service started");
        return userRepository.save(user);
    }
}
