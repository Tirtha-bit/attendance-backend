package com.tirtha.attendance_backend.dto;

import java.time.LocalDate;

public class AttendanceResponse {

    private Long studentId;
    private LocalDate date;
    private String status;

    public AttendanceResponse(Long studentId, LocalDate date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
