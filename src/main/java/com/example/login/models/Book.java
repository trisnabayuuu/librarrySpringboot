package com.example.login.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 50)
    private String title;

    @Column(length = 4)
    private String year;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private Boolean isDeleted = false;
    
    public Book(String title, String year, Author author, Publisher publisher) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.publisher = publisher;
    }

    

}
