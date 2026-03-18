package com.example.jms.service;

import com.example.jms.model.Book;
import com.example.jms.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.jms.util.ValidationUtil.checkNotFoundWithId;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        Assert.notNull(book, "Book must not be null");
        return bookRepository.save(book);
    }

    public Book update(long id, Book updatedBook) {
        Assert.notNull(updatedBook, "Book must not be null");
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setGenre(updatedBook.getGenre());
                    book.setYear(updatedBook.getYear());
                    book.setRating(updatedBook.getRating());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    public Book get(long id) {
        bookRepository.findById(id);
        return checkNotFoundWithId(bookRepository.findById(id), id);
    }

    public void delete(long id) {
        Book book = get(id);
        bookRepository.delete(book);
    }

    public List<Book> getAllSorted() {
        return bookRepository.getAllSortedByYearDesc();
    }
}