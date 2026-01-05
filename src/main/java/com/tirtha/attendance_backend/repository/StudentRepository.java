package com.tirtha.attendance_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tirtha.attendance_backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
