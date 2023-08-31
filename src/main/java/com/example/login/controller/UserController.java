package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.payloads.req.UserRequest;
import com.example.login.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequest request){
        // try {
            return userService.addUserService(request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid UserRequest request) {
        // try {
            return userService.loginUserService(request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

}
