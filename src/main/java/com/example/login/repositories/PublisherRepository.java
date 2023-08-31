package com.example.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
  List<Publisher> findByIsDeleted(Boolean isDeleted);

  List<Publisher> findByIsDeletedFalse();

  List<Publisher> findByIsDeletedTrue();

  List<Publisher> findByNameContaining(String name);

  Publisher findByName(String name);
}
