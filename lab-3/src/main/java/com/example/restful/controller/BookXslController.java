package com.example.restful.controller;

import com.example.restful.model.Book;
import com.example.restful.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.List;

@Controller
@RequestMapping(
        value = "/books/xsl"
)
public class BookXslController {
    private final BookService bookService;
    private final XmlMapper xmlMapper;

    public BookXslController(BookService bookService, XmlMapper xmlMapper) {
        this.bookService = bookService;
        this.xmlMapper = xmlMapper;
    }

    @GetMapping
    public ModelAndView getBooksXsl() throws JsonProcessingException {
        List<Book> books = bookService.getAllSorted();
        String xmlContent = xmlMapper.writeValueAsString(books);

        StreamSource source = new StreamSource(new StringReader(xmlContent));

        ModelAndView modelAndView = new ModelAndView("books"); // Имя шаблона XSLT
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getBooksXsl(@PathVariable long id) throws JsonProcessingException {
        Book book = bookService.get(id);
        String xmlContent = xmlMapper.writeValueAsString(book);

        StreamSource source = new StreamSource(new StringReader(xmlContent));

        ModelAndView modelAndView = new ModelAndView("book"); // Имя шаблона XSLT
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}