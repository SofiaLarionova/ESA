package ru.ssau.labs.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtil {
    public static java.sql.Date convertJavaDateToSql(Date jDate) {
        return new java.sql.Date(jDate.getTime());
    }

    public static Date convertStringToJavaDate(String strDate, DateFormat dateFormat) {
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use 'yyyy-MM-dd'.");
        }
    }
}