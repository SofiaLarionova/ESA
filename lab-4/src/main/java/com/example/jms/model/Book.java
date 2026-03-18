package com.example.jms.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books", indexes = @Index(name = "books_title_uindex", columnList = "title", unique = true))
public class Book extends AbstractBaseEntity {

    @Column(name = "title", nullable = false, unique = true, length = 255)
    private String title;

    @Column(name = "genre", length = 100)
    private String genre;

    @Column(name = "year")
    private Integer year;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    public Book(Long id, String title, String genre, Integer year, BigDecimal rating) {
        super(id);
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Book(String title, String genre, Integer year, BigDecimal rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}