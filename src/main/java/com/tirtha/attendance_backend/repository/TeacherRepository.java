package com.tirtha.attendance_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tirtha.attendance_backend.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
