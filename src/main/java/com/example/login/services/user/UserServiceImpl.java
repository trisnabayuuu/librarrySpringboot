package com.example.login.services.user;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.login.exception.EntityFoundException;
import com.example.login.models.Peminjaman;
import com.example.login.models.User;
import com.example.login.payloads.req.UserRequest;
import com.example.login.payloads.res.ResponseHandler;
import com.example.login.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUserService(UserRequest request) {
        // validasi name
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new EntityFoundException("Name user is required!");
        }

        // convert request menjadi model entity
        User user = new User(request.getUsername(), request.getPassword());
        // save ke db
        userRepository.save(user);
        return ResponseHandler.responseMessage(201, "user successfully added!", true);
    }

    @Override
    public ResponseEntity<?> getUserService(Boolean isDeleted) {
        List<User> user = new ArrayList<>();
        // cek is deleted null atau tidak
        if (isDeleted == null) {
            user = userRepository.findAll();
        } else {
            user = userRepository.findByIsDeleted(isDeleted);
        }

        // return response data
        return ResponseHandler.responseData(200, "success", user);
    }

    @Override
    public ResponseEntity<?> getUserByIdService(String id) {

        return null;
    }

    @Override
    public ResponseEntity<?> loginUserService(UserRequest request) {
        // login
        // validasi jika username tidak ada
        if (!userRepository.existsByUsername(request.getUsername())){
            throw new NoSuchElementException("username tidak ada");
        }
        User user = userRepository.findByUsername(request.getUsername());

        //validasi password
        if (user.getIsDeleted()){
            throw new NoSuchElementException("user sudah dihapus");
        }

        // validasi password
        if (!user.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Bad Credentials: password tidak sesuai");
        }
            return ResponseHandler.responseData(200, "success", user);
    }

}
