package com.quest.mongotest.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quest.mongotest.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Add custom query methods if needed
}
