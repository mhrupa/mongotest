package com.quest.mongotest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.quest.mongotest.entities.User;
import com.quest.mongotest.repositories.UserRepository;

@DataMongoTest
@AutoConfigureTestEntityManager
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        // Create a user
    	User user = new User("1", "testFirstName1", "testLastName1");

        // Save the user to the repository
        User savedUser = userRepository.save(user);

        // Retrieve the user from the repository
        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);

        // Verify that the retrieved user is not null and has the same properties as the saved user
        assertEquals(savedUser.getId(), retrievedUser.getId());
        assertEquals("testFirstName1", retrievedUser.getFirstName());
        assertEquals("testLastName1", retrievedUser.getLastName());
    }
}

