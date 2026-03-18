package ru.ssau.labs.exception;

public class StorageException extends RuntimeException {
    private final Integer id;

    public StorageException(String message) {
        this(null, message, null);
    }

    public StorageException(Exception e) {
        this(e.getMessage(), e);
    }

    public StorageException(Integer id, String message) {
        super(message);
        this.id = id;
    }

    public StorageException(String message, Exception e) {
        this(null, message, e);
    }

    public StorageException(Integer id, String message, Exception e) {
        super(message, e);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}