package com.example.demo.model;

import lombok.Data; // <-- IMPORT LOMBOK
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

@Data // <-- ADD THIS ANNOTATION
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