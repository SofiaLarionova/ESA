package ru.ssau.labs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ssau.labs.spring.model.Book;
import ru.ssau.labs.spring.service.BookService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Book> books = bookService.getAllSorted();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/create")
    public String create(@RequestParam String title,
                         @RequestParam String genre,
                         @RequestParam Integer year,
                         @RequestParam BigDecimal rating) {
        bookService.create(title, genre, year, rating);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Book book = bookService.get(Math.toIntExact(id));
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam String genre,
                         @RequestParam Integer year,
                         @RequestParam BigDecimal rating) {
        bookService.update(id, title, genre, year, rating);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
