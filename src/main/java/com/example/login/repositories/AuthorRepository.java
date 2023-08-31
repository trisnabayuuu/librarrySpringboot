package com.example.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.login.models.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {

    List<Author> findByIsDeleted(Boolean isDeleted);

    Boolean existsByAuthorName(String authorName);

    Author findByAuthorName(String authorName);

    boolean existsBySocialMedia(String socialMedia);

    Author findBySocialMedia(String socialMedia);

    @Query(value = "select * from authors where author_name like %?%", nativeQuery = true)
    List<Author> getAuthorByName(String name);

}
