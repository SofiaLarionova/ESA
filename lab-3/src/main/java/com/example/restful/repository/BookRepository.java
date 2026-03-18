package com.example.restful.repository;

import com.example.restful.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.year DESC")
    List<Book> getAllSortedByYearDesc();
}