package com.quest.mongotest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
}
