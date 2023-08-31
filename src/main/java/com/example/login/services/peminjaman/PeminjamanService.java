package com.example.login.services.peminjaman;

import org.springframework.http.ResponseEntity;

import com.example.login.payloads.req.PeminjamanRequest;

public interface PeminjamanService {
    //     // create peminjaman
    ResponseEntity<?> addPeminjaman(PeminjamanRequest request);
    

    // // get all or by status deleted
    ResponseEntity<?> getPeminjamanService(Boolean isDeleted);

    // // get  by id
    ResponseEntity<?> getPeminjamanByIdService(String id);

    // // update by id
    ResponseEntity<?> updatePeminjamanService(String id);

    // // delete  by id
    ResponseEntity<?> deletePeminjamanService(String id);
}
