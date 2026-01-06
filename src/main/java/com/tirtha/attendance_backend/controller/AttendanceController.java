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
import com.tirtha.attendance_backend.dto.AttendanceResponse;
import com.tirtha.attendance_backend.entity.Attendance;
import com.tirtha.attendance_backend.service.AttendanceService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @Operation(summary = "Mark attendance for a student (Teacher only)")
    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("/mark")
    public ResponseEntity<AttendanceResponse> markAttendance(
            @Valid @RequestBody AttendanceMarkRequest request) {

        Attendance attendance = attendanceService.markAttendance(request);

        AttendanceResponse response = new AttendanceResponse(
                attendance.getStudent().getId(),
                attendance.getDate(),
                attendance.getStatus().name()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "View attendance records for a student")
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student/{id}")
    public List<AttendanceResponse> viewAttendance(@PathVariable Long id) {

        return attendanceService.getAttendanceForStudent(id)
                .stream()
                .map(a -> new AttendanceResponse(
                        a.getStudent().getId(),
                        a.getDate(),
                        a.getStatus().name()
                ))
                .toList();
    }
}
