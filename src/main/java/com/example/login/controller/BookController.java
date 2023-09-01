package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.payloads.req.BookRequest;
import com.example.login.services.book.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest request) {

        return bookService.addBookService(request);

    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {

        return bookService.getBooksService(isDeleted);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooksById(@PathVariable String id) {
 
        return bookService.getBookByIdService(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooksById(@PathVariable String id, @RequestBody @Valid BookRequest request) {

        return bookService.updateBookService(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooksById(@PathVariable String id) {
        // try {
        return bookService.deleteBookService(id);
        // } catch (Exception e) {
        // return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }
}
