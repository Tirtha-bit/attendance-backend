package com.tirtha.attendance_backend.service;

import com.tirtha.attendance_backend.dto.StudentCreateRequest;
import com.tirtha.attendance_backend.entity.Student;

public interface StudentService {
    Student createStudent(StudentCreateRequest request);
}
