package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserCriterias;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll(UserCriterias criterias) {
        Specification<User> userSpecification = UserSpecification.findBy(criterias);
        return userRepository.findAll(userSpecification);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
