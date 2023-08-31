package com.example.login.services.peminjaman;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.login.models.Book;
import com.example.login.models.Peminjaman;
import com.example.login.models.User;
import com.example.login.payloads.req.PeminjamanRequest;
import com.example.login.payloads.res.ResponseHandler;
import com.example.login.repositories.BookRepository;
import com.example.login.repositories.PeminjamanRepository;
import com.example.login.repositories.UserRepository;
import com.example.login.validator.BookValidation;
import com.example.login.validator.UserValidation;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookValidation bookValidation;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidation userValidation;

    @Autowired
    PeminjamanRepository peminjamanRepository;
    @Override
    public ResponseEntity<?> addPeminjaman(PeminjamanRequest request) {
        // if (bookRepository.existsByTitle(request.getBuku())) {
        //     throw new EntityFoundException("nama sudah ada");
        // }
        // cek inputan 
        //user
        User user = userRepository.findByUsername(request.getUser());
        userValidation.validateUser(user);
        
        //buku
        Book book = bookRepository.findByTitle(request.getBuku());
        
        bookValidation.validateBook(book);

        Peminjaman peminjaman = new Peminjaman(user, book);
        
        peminjaman.setIsDeleted(true);
        
        peminjamanRepository.save(peminjaman);

        return ResponseHandler.responseMessage(201, "peminjaman berhasil dilakukan!", true);
    }

    @Override
    public ResponseEntity<?> deletePeminjamanService(String id) {
        //method untuk mengembalikan buku
        Peminjaman peminjaman = peminjamanRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id book is not found!");
        });

        peminjaman.setIsDeleted(false);
        peminjamanRepository.save(peminjaman);

        return ResponseHandler.responseMessage(200, "Successfully deleted!", true);
    
    }

    @Override
    public ResponseEntity<?> getPeminjamanByIdService(String id) {

        return null;
    }

    @Override
    public ResponseEntity<?> getPeminjamanService(Boolean isDeleted) {
        List<Peminjaman> peminjaman = new ArrayList<>();
        // cek is deleted null atau tidak
        if (isDeleted == null) {
            peminjaman = peminjamanRepository.findAll();
        } else {
            peminjaman = peminjamanRepository.findByIsDeleted(isDeleted);
        }

        // return response data
        return ResponseHandler.responseData(200, "success", peminjaman);
    }

    @Override
    public ResponseEntity<?> updatePeminjamanService(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
