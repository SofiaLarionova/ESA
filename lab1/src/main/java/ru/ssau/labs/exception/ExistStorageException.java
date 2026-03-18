package ru.ssau.labs.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(Integer id, String entityName) {
        super(id, "Entity " + entityName + " " + id + " already exist");
    }

    public ExistStorageException(Exception e) {
        super("Entity already exist: ", e);
    }
}
