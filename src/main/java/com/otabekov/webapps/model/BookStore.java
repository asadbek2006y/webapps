package com.otabekov.webapps.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String genre;
    private double price;
    @Column(name = "publish_date")
    private LocalDate dot;

    public BookStore() {}

    public BookStore(Long id, String title, String author, String genre, double price, LocalDate dot) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.dot = dot;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDot() {
        return dot;
    }

    public void setDot(LocalDate dot) {
        this.dot = dot;
    }



}
