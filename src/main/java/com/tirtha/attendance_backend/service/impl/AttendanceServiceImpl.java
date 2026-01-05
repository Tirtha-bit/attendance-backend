package com.tirtha.attendance_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tirtha.attendance_backend.dto.AttendanceMarkRequest;
import com.tirtha.attendance_backend.entity.Attendance;
import com.tirtha.attendance_backend.entity.Student;
import com.tirtha.attendance_backend.repository.AttendanceRepository;
import com.tirtha.attendance_backend.repository.StudentRepository;
import com.tirtha.attendance_backend.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
                                StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Attendance markAttendance(AttendanceMarkRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(request.getDate());
        attendance.setStatus(request.getStatus());

        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceForStudent(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }
}
