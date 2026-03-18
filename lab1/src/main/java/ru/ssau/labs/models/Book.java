package ru.ssau.labs.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private final Integer id;
    private final String title;
    private final String genre;
    private final BigDecimal rating;
    private final int year;

    public Book(Integer id, String title, String genre, BigDecimal rating, int year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public Book(String title, String genre, BigDecimal rating, int year) {
        this.id = null;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getRating() {
        return rating;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}