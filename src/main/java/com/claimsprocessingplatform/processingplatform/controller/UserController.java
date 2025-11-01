package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService; // <-- IMPORT SERVICE
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {

    // Inject the SERVICE, not the repository
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Delegate all logic to the service
        return userService.createUser(user)
                .map(savedUser -> new ResponseEntity<>(savedUser, HttpStatus.CREATED)) // 201
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT)); // 409
    }

    @GetMapping
    public List<User> getAllUsers() {
        // Simple passthrough
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        // Use service to find, then map Optional to ResponseEntity
        return userService.getUserById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        
        return userService.updateUser(id, userDetails)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        // Use service to delete, then check boolean result
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}