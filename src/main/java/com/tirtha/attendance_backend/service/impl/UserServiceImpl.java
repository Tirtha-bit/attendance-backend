package com.tirtha.attendance_backend.service.impl;

import com.tirtha.attendance_backend.dto.UserCreateRequest;
import com.tirtha.attendance_backend.entity.User;
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

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // hashing later
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}
