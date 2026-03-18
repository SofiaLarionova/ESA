package ru.ssau.labs.repository;


import ru.ssau.labs.exception.NotExistStorageException;
import ru.ssau.labs.models.Book;
import ru.ssau.labs.sql.SQLHelper;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BookStorage implements Storage<Book> {
    private static final Logger LOG = Logger.getLogger(BookStorage.class.getName());
    private final SQLHelper sqlHelper;

    public BookStorage(String dbUrl, String dbUser, String dbPassword) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        sqlHelper = new SQLHelper(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        LOG.info("Clear book storage");
        sqlHelper.execute("TRUNCATE stephen_king_books CASCADE");
    }

    @Override
    public void save(Book book) {
        LOG.info("Save book " + book.getId());
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO stephen_king_books (title, genre, rating, year) VALUES (?,?,?,?)")) {
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setBigDecimal(3, book.getRating());
                preparedStatement.setInt(4, book.getYear());
                preparedStatement.execute();
            }
            return null;
        });
    }

    @Override
    public void update(Book book) {
        LOG.info("Update book " + book.getId());
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE stephen_king_books b SET  title=?, genre=?, rating=?, year=? WHERE b.id=?")) {
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setBigDecimal(3, book.getRating());
                preparedStatement.setInt(4, book.getYear());
                preparedStatement.setInt(5, book.getId());
                if (preparedStatement.executeUpdate() != 1) {
                    throw new NotExistStorageException(book.getId(), Book.class.getSimpleName());
                }
                return null;
            }
        });
    }

    @Override
    public Book get(Integer id) {
        LOG.info("Get book " + id);
        return sqlHelper.transactionalExecute(conn -> {
            Book book;
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM stephen_king_books b WHERE b.id =?")) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    throw new NotExistStorageException(id, Book.class.getSimpleName());
                }
                book = new Book(
                        id,
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getBigDecimal("rating"),
                        resultSet.getInt("year"));
            }
            return book;
        });
    }

    @Override
    public void delete(Integer id) {
        LOG.info("Delete book " + id);
        sqlHelper.<Void>execute("DELETE FROM stephen_king_books b WHERE b.id =?", (preparedStatement) -> {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                throw new NotExistStorageException(id, Book.class.getSimpleName());
            }
            return null;
        });
    }

    @Override
    public List<Book> getAllSorted() {
        LOG.info("Get all books");
        Map<Integer, Book> book = new LinkedHashMap<>();
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM stephen_king_books b ORDER BY title, id")) {
                ResultSet bookSet = preparedStatement.executeQuery();
                while (bookSet.next()) {
                    Integer id = bookSet.getInt("id");
                    String title = bookSet.getString("title");
                    String genre = bookSet.getString("genre");
                    int year = bookSet.getInt("year");
                    BigDecimal rating = bookSet.getBigDecimal("rating");
                    book.put(id, new Book(id, title, genre, rating, year));
                }
            }
            return null;
        });
        return new ArrayList<>(book.values());
    }

    @Override
    public int size() {
        LOG.info("Get book-storage size");
        return sqlHelper.execute("SELECT COUNT(*) AS count FROM stephen_king_books b", (preparedStatement) -> {
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next() ? rs.getInt("count") : 0;
        });
    }
}
