package ru.ssau.labs.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(Integer id, String entityName) {
        super(id, "Entity " + entityName + " " + id + " not exist");
    }
}
