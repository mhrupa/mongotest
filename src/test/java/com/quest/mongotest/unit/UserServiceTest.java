package com.quest.mongotest.unit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.quest.mongotest.entities.User;
import com.quest.mongotest.repositories.UserRepository;
import com.quest.mongotest.services.UserService;

class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Create a list of users for the mock repository
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "testFirstName1", "testLastName1"));
        userList.add(new User("2", "testFirstName2", "testLastName2"));

        // Mock the userRepository.findAll() method to return the list of users
        when(userRepository.findAll()).thenReturn(userList);

        // Call the method to be tested
        List<User> result = userService.getAllUsers();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("testFirstName1", result.get(0).getFirstName());
        assertEquals("testFirstName2", result.get(1).getFirstName());

        // Verify that the userRepository.findAll() method was called once
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testSaveUser() {
        // Create a user to be saved
        User user = new User("1", "testFirstName1", "tetsLastName1");

        // Mock the userRepository.save() method
        when(userRepository.save(user)).thenReturn(user);

        // Call the method to be tested
        User result = userService.createUser(user);

        // Verify the result
        assertEquals("testFirstName1", result.getFirstName());

        // Verify that the userRepository.save() method was called once
        verify(userRepository, times(1)).save(user);
    }
}
