package com.tirtha.attendance_backend.service.impl;

import com.tirtha.attendance_backend.dto.UserCreateRequest;
import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.exception.DuplicateResourceException;
import com.tirtha.attendance_backend.repository.UserRepository;
import com.tirtha.attendance_backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserCreateRequest request) {

        // ✅ STEP 1: duplicate email check (BUSINESS RULE)
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already exists");
        }

        // ✅ STEP 2: create user entity
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // hashing later (Day 5)
        user.setRole(request.getRole());

        // ✅ STEP 3: save user
        return userRepository.save(user);
    }
}
