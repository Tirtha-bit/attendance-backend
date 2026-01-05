package com.tirtha.attendance_backend.service.impl;

import org.springframework.stereotype.Service;

import com.tirtha.attendance_backend.dto.TeacherCreateRequest;
import com.tirtha.attendance_backend.entity.Role;
import com.tirtha.attendance_backend.entity.Teacher;
import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.repository.TeacherRepository;
import com.tirtha.attendance_backend.repository.UserRepository;
import com.tirtha.attendance_backend.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Teacher createTeacher(TeacherCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.TEACHER) {
            throw new RuntimeException("User is not a TEACHER");
        }

        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setEmployeeId(request.getEmployeeId());
        teacher.setUser(user);

        return teacherRepository.save(teacher);
    }
}
