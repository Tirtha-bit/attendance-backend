package com.tirtha.attendance_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirtha.attendance_backend.dto.TeacherCreateRequest;
import com.tirtha.attendance_backend.entity.Teacher;
import com.tirtha.attendance_backend.service.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Operation(summary = "Create a teacher profile (Admin only)")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(
            @Valid @RequestBody TeacherCreateRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(teacherService.createTeacher(request));
    }
}
