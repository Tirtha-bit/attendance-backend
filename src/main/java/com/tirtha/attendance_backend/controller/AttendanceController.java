package com.tirtha.attendance_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirtha.attendance_backend.dto.AttendanceMarkRequest;
import com.tirtha.attendance_backend.entity.Attendance;
import com.tirtha.attendance_backend.service.AttendanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("/mark")
    public ResponseEntity<Attendance> markAttendance(
            @Valid @RequestBody AttendanceMarkRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(attendanceService.markAttendance(request));
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student/{id}")
    public List<Attendance> viewAttendance(@PathVariable Long id) {
        return attendanceService.getAttendanceForStudent(id);
    }
}
