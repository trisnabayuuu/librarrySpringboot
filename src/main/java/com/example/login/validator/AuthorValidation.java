package com.example.login.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.login.models.Author;

@Component
public class AuthorValidation {
    public void validateAuthor(Author author) {
        if (author == null || Objects.isNull(author)) {
            throw new NoSuchElementException("Author is not found!");
        }
    }
}
