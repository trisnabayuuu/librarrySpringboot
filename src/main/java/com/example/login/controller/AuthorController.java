package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.payloads.req.AuthorRequest;
import com.example.login.services.author.AuthorService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorRequest request){
        return authorService.addAuthorService(request);
    }
    
    @GetMapping
    public ResponseEntity<?> getAuthor() {
        return authorService.getAuthorService();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id){
        return authorService.getAuthorByIdService(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAuthorByName(@PathVariable String name){
        return authorService.getAuthorByNameService(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable String id, @RequestBody AuthorRequest request) {
        //TODO: process PUT request
        
        return authorService.updateAuthorByIdService(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable String id){
        return authorService.deleteAuthorByIdService(id);
    }

}
