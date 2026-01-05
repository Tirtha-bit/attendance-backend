package com.tirtha.attendance_backend.dto;

import java.time.LocalDate;

import com.tirtha.attendance_backend.entity.AttendanceStatus;

import jakarta.validation.constraints.NotNull;

public class AttendanceMarkRequest {

    @NotNull
    private Long studentId;

    @NotNull
    private LocalDate date;

    @NotNull
    private AttendanceStatus status;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
