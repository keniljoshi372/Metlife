package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

// This is the core of your logical schema definition
@Document(collection = "users") 
public class User {

    @Id
    private String id; 

    @Field("name")
    private String fullName;

    @Indexed(unique = true)
    private String email;

    private String phonenumber;
}