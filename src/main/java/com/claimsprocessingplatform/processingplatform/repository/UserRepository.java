package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

// This interface handles all your database queries
// It extends MongoRepository for User, which has an ID of type String
public interface UserRepository extends MongoRepository<User, String> {

    // Spring Data MongoDB will automatically create this query for you
    // because you defined 'email' as an indexed field.
    Optional<User> findByEmail(String email);
}