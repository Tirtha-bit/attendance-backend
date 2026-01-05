package com.tirtha.attendance_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tirtha.attendance_backend.entity.Attendance;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentId(Long studentId);
}
