package com.example.login.services.user;

import org.springframework.http.ResponseEntity;

import com.example.login.payloads.req.UserRequest;

public interface UserService {
    ResponseEntity<?> addUserService(UserRequest request);

    ResponseEntity<?> loginUserService(UserRequest request);

    ResponseEntity<?> getUserByIdService(String id);
}

