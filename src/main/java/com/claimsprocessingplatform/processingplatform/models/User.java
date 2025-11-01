package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

// This is the core of your logical schema definition
@Document(collection = "users") 
public class User {

    // Primary Key: Maps to MongoDB's special _id field
    @Id
    private String id; 

    // Custom Field Name: Maps the 'fullName' Java field to 'name' in MongoDB
    @Field("name")
    private String fullName;

    // Indexed Field: Creates a unique index on the 'email' field in MongoDB
    @Indexed(unique = true)
    private String email;

    // Simple Field: Maps to a field named 'age' in MongoDB
    private int age;
}