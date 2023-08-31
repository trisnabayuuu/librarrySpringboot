package com.example.login.services.author;

import org.springframework.http.ResponseEntity;

import com.example.login.payloads.req.AuthorRequest;

public interface AuthorService {
    ResponseEntity<?> addAuthorService(AuthorRequest request);

    ResponseEntity<?> getAuthorService();
    
    ResponseEntity<?> getAuthorByIdService(String id);

    ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request);

    ResponseEntity<?> deleteAuthorByIdService(String id);

    ResponseEntity<?> getAuthorByNameService(String name);
}
