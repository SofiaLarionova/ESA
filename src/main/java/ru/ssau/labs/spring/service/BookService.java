package ru.ssau.labs.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.ssau.labs.spring.model.Book;
import ru.ssau.labs.spring.repository.EntityRepository;

import java.math.BigDecimal;
import java.util.List;

import static ru.ssau.labs.spring.util.ValidationUtil.checkNotFoundWithId;


@Service
public class BookService {
    private final EntityRepository<Book> bookRepository;

    public BookService(EntityRepository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void create(String title, String genre, Integer year, BigDecimal rating) {
        bookRepository.save(new Book(title, genre, year, rating));
    }

    public void update(Long id, String title, String genre, Integer year, BigDecimal rating) {
        Assert.notNull(id, "Book id must not be null");
        bookRepository.save(new Book(id, title, genre, year, rating));
    }

    public Book get(long id) {
        return checkNotFoundWithId(bookRepository.get(id), id);
    }

    public void delete(long id) {
        checkNotFoundWithId(bookRepository.delete(id), id);
    }

    public List<Book> getAllSorted() {
        return bookRepository.getAllSorted();
    }

}