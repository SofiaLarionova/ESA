package ru.ssau.labs.sql;


import org.postgresql.util.PSQLException;
import ru.ssau.labs.exception.ExistStorageException;
import ru.ssau.labs.exception.StorageException;

import java.sql.SQLException;

public class SQLConverterException {
    public static StorageException convert(SQLException e) {
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) return new ExistStorageException(e);
        }
        return new StorageException(e);
    }
}
