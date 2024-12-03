package com.example.demo.resource;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable @NotNull Long id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.of(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAll() { // TODO queryparam
        List<User> all = userService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        User saved = userService.save(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
