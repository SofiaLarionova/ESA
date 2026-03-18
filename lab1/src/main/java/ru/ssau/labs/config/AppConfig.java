package ru.ssau.labs.config;

import org.aeonbits.owner.ConfigFactory;
import ru.ssau.labs.repository.BookStorage;
import ru.ssau.labs.repository.CvModelStorage;
import ru.ssau.labs.service.BookService;
import ru.ssau.labs.service.CvModelService;

public class AppConfig {
    AppProperties appProperties = ConfigFactory.create(AppProperties.class, System.getProperties());

    private static final AppConfig APP_CONFIG = new AppConfig();

    private final BookStorage bookStorage;
    private final CvModelStorage cvModelStorage;
    private final BookService bookService;
    private final CvModelService cvModelService;

    private AppConfig() {
        String dbUrl = appProperties.getDatabaseUrl();
        String dbUser = appProperties.getDatabaseUser();
        String dbPassword = appProperties.getDatabasePassword();

        try {
            bookStorage = new BookStorage(dbUrl, dbUser, dbPassword);
            cvModelStorage = new CvModelStorage(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Invalid DB config: " + e);
        }

        bookService = new BookService(bookStorage);
        cvModelService = new CvModelService(cvModelStorage);
    }

    public static AppConfig get() {
        return APP_CONFIG;
    }

    public BookService getBookService() {
        return bookService;
    }

    public CvModelService getCvModelService() {
        return cvModelService;
    }

    public String getDateFormat() {
        return appProperties.getDateFormat();
    }
}