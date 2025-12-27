package com.tirtha.attendance_backend.service;

public interface AuthService {

    /**
     * Validates user credentials and returns JWT token
     *
     * @param email    user's email
     * @param password raw password from login request
     * @return JWT token if credentials are valid
     */
    String login(String email, String password);
}
