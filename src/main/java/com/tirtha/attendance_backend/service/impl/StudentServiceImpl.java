package com.tirtha.attendance_backend.service.impl;

import org.springframework.stereotype.Service;

import com.tirtha.attendance_backend.dto.StudentCreateRequest;
import com.tirtha.attendance_backend.entity.Role;
import com.tirtha.attendance_backend.entity.Student;
import com.tirtha.attendance_backend.entity.User;
import com.tirtha.attendance_backend.repository.StudentRepository;
import com.tirtha.attendance_backend.repository.UserRepository;
import com.tirtha.attendance_backend.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Student createStudent(StudentCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.STUDENT) {
            throw new RuntimeException("User is not a STUDENT");
        }

        Student student = new Student();
        student.setName(request.getName());
        student.setRollNumber(request.getRollNumber());
        student.setUser(user);

        return studentRepository.save(student);
    }
}





