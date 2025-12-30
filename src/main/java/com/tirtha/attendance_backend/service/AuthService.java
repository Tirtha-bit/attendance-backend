package com.tirtha.attendance_backend.service;

import com.tirtha.attendance_backend.dto.LoginRequest;
import com.tirtha.attendance_backend.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}

