package com.tirtha.attendance_backend.service.impl;

import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.repository.UserRepository;
import com.tirtha.attendance_backend.security.JwtUtil;
import com.tirtha.attendance_backend.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tirtha.attendance_backend.exception.InvalidCredentialsException;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(InvalidCredentialsException::new);


        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException();

        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
