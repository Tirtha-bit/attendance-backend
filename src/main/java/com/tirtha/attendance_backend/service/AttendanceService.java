package com.tirtha.attendance_backend.service;

import java.util.List;

import com.tirtha.attendance_backend.dto.AttendanceMarkRequest;
import com.tirtha.attendance_backend.entity.Attendance;

public interface AttendanceService {

    Attendance markAttendance(AttendanceMarkRequest request);

    List<Attendance> getAttendanceForStudent(Long studentId);
}
