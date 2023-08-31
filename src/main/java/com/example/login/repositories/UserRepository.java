package com.example.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByIsDeleted(Boolean isDeleted);

    Boolean existsByUsername(String username);
    User findByUsername(String username);

}
