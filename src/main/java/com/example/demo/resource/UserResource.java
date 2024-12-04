package com.example.demo.resource;

import com.example.demo.domain.User;
import com.example.demo.repository.UserCriterias;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable @NotNull Long id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.of(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findBy(@Valid UserCriterias criterias) {
        List<User> all = userService.findAll(criterias);
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @NotNull @Valid User user) {
        User saved = userService.save(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
