package com.tirtha.attendance_backend.service.impl;

import com.tirtha.attendance_backend.dto.UserCreateRequest;
import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.exception.DuplicateResourceException;
import com.tirtha.attendance_backend.repository.UserRepository;
import com.tirtha.attendance_backend.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
           this.userRepository = userRepository;
           this.passwordEncoder = passwordEncoder;
}

    @Override
public User createUser(UserCreateRequest request) {

    User user = new User();
    user.setEmail(request.getEmail());

    // 🔥 HASH PASSWORD HERE
    user.setPassword(
        passwordEncoder.encode(request.getPassword())
    );

       user.setRole(request.getRole());

       return userRepository.save(user);
    }

}
