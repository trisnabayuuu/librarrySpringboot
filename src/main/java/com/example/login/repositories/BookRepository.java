package com.example.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.models.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByIsDeleted(Boolean isDeleted);

    Book findByTitle(String title);

    // Boolean existsByTitle(String title);
}
