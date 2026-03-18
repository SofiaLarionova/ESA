package ru.ssau.labs.controller;


import ru.ssau.labs.config.AppConfig;
import ru.ssau.labs.models.Book;
import ru.ssau.labs.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class BookServlet extends HttpServlet {

    private BookService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = AppConfig.get().getBookService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Book book = service.get(id);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/WEB-INF/view/updateBook.jsp").forward(request, response);
        } else {
            List<Book> books = service.getAllSorted();
            request.setAttribute("books", books);
            request.getRequestDispatcher("/WEB-INF/view/books.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title, genre;
        int id, year;
        BigDecimal rating;

        String action = request.getParameter("action");

        switch (action) {
            case "clear":
                service.clear();
                break;
            case "save":
                title = request.getParameter("title");
                genre = request.getParameter("genre");
                rating = new BigDecimal(request.getParameter("rating"));
                year = Integer.parseInt(request.getParameter("year"));
                service.save(title, genre, rating, year);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                title = request.getParameter("title");
                genre = request.getParameter("genre");
                rating = new BigDecimal(request.getParameter("rating"));
                year = Integer.parseInt(request.getParameter("year"));
                service.update(id, title, genre, rating, year);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                service.delete(id);
                break;
        }

        response.sendRedirect(request.getContextPath() + "/books");
    }
}
