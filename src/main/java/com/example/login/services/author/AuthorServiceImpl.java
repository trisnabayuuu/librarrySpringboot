package com.example.login.services.author;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.login.exception.EntityFoundException;
import com.example.login.models.Author;
import com.example.login.payloads.req.AuthorRequest;
import com.example.login.payloads.res.ResponseHandler;
import com.example.login.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public ResponseEntity<?> addAuthorService(AuthorRequest request) {
        // validasi name
        if (authorRepository.existsByAuthorName(request.getAuthorName())) {
            throw new EntityFoundException("nama sudah ada");
        }
        if (authorRepository.existsBySocialMedia(request.getSocialMedia())) {
            throw new EntityFoundException(" sosial media sudah ada");
        }

        // convert request menjadi model entity
        Author author = new Author(request.getAuthorName(), request.getSocialMedia());
        // save ke db
        authorRepository.save(author);
        return ResponseHandler.responseMessage(201, "user successfully added!", true);
    }

    @Override
    public ResponseEntity<?> getAuthorByIdService(String id) {
        // jika id tidak ada maka akan muncul throw exception
        if (!authorRepository.existsById(id)) {
            throw new NoSuchElementException("id is not found!");
        }

        // lalu find data author by id nya
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found!");
        });
        return ResponseHandler.responseData(200, "success", author);
    }

    @Override
    public ResponseEntity<?> getAuthorService() {
        List<Author> author = authorRepository.findAll();

        return ResponseHandler.responseData(200, "success", author);
    }

    @Override
    public ResponseEntity<?> deleteAuthorByIdService(String id) {

        // find id
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found!");
        });
        author.setIsDeleted(true);

        // save ke db
        authorRepository.save(author);

        // return response
        return ResponseHandler.responseData(200, "Author successfully deleted!", null);

    }

    @Override
    public ResponseEntity<?> getAuthorByNameService(String name) {
        List<Author> author = authorRepository.getAuthorByName(name);
        return ResponseHandler.responseData(200, "success", author);
    }

    @Override
    public ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request) {
        Author author = authorRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found!");
        });

        // ubah data
        if (request.getAuthorName() != "") {
            author.setAuthorName(request.getAuthorName());
        }

        if (request.getSocialMedia() != "") {
            author.setSocialMedia(request.getSocialMedia());
        }

        // lalu simpan
        authorRepository.save(author);

        return ResponseHandler.responseData(200, "success", author);
    }

}
