package ru.ssau.labs.service;

import ru.ssau.labs.models.Book;
import ru.ssau.labs.repository.BookStorage;

import java.math.BigDecimal;
import java.util.List;

public class BookService {

    private final BookStorage bookStorage;

    public BookService(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public void clear() {
        bookStorage.clear();
    }

    public void save(String title, String genre, BigDecimal rating, int year) {
        Book book = new Book(title, genre, rating, year);
        bookStorage.save(book);
    }

    public void update(Integer id, String title, String genre, BigDecimal rating, int year) {
        Book book = new Book(id, title, genre, rating, year);
        bookStorage.update(book);
    }

    public Book get(Integer id) {
        return bookStorage.get(id);
    }

    public void delete(Integer id) {
        bookStorage.delete(id);
    }

    public List<Book> getAllSorted() {
        return bookStorage.getAllSorted();
    }

    int size() {
        return bookStorage.size();
    }
}
