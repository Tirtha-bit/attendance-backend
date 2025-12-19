package com.tirtha.attendance_backend.service;

import com.tirtha.attendance_backend.dto.UserCreateRequest;
import com.tirtha.attendance_backend.entity.User;

public interface UserService {

    User createUser(UserCreateRequest request);
}
