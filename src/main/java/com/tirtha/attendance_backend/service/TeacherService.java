package com.tirtha.attendance_backend.service;

import com.tirtha.attendance_backend.dto.TeacherCreateRequest;
import com.tirtha.attendance_backend.entity.Teacher;

public interface TeacherService {
    Teacher createTeacher(TeacherCreateRequest request);
}
