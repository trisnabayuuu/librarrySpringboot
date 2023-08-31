package com.example.login.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.login.models.Book;

@Component
public class BookValidation {
    public void validateBook(Book book) {
        if (book == null || Objects.isNull(book)) {
            throw new NoSuchElementException("book is not found!");
        }
    }
}
