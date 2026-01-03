package com.tirtha.attendance_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ AUTHENTICATED USER (ANY ROLE)
    @GetMapping("/me")
    public ResponseEntity<?> currentUser(Authentication authentication) {
        return ResponseEntity.ok(
                Map.of("email", authentication.getName())
        );
    }

    // 🔒 ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 🔒 TEACHER ONLY
    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher-only")
    public String teacherEndpoint() {
        return "Teacher access granted";
    }

    // 🔒 STUDENT ONLY
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student-only")
    public String studentEndpoint() {
        return "Student access granted";
    }
}

