package com.example.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.models.Peminjaman;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, String> {
    List<Peminjaman> findByIsDeleted(Boolean isStatus);
}
