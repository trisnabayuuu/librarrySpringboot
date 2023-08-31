package com.example.login.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.login.models.User;

@Component
public class UserValidation {
    public void validateUser(User user) {
        if (user == null || Objects.isNull(user)) {
            throw new NoSuchElementException("User is not found!");
        }
    }
}