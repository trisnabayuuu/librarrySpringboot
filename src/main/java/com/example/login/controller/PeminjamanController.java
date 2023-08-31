package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.payloads.req.PeminjamanRequest;
import com.example.login.services.peminjaman.PeminjamanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
@Autowired
PeminjamanService peminjamanService;

    @PostMapping
    public ResponseEntity<?> createPeminjaman(@RequestBody @Valid PeminjamanRequest request) {
        return peminjamanService.addPeminjaman(request);
    }

    @GetMapping
    public ResponseEntity<?> getPeminjaman(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        return peminjamanService.getPeminjamanService(isDeleted);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeminjaman(@PathVariable String id) {

        return peminjamanService.deletePeminjamanService(id);
    }
}
