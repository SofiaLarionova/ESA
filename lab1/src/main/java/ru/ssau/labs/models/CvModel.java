package ru.ssau.labs.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class CvModel {
    private final Integer id;
    private final String name;
    private final Date release;
    private final BigDecimal score;

    public CvModel(Integer id, String name, Date release, BigDecimal score) {
        this.id = id;
        this.name = name;
        this.release = release;
        this.score = score;
    }

    public CvModel(String name, Date release, BigDecimal score) {
        this.id = null;
        this.name = name;
        this.release = release;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getRelease() {
        return release;
    }


    public BigDecimal getScore() {
        return score;

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CvModel cvModel)) return false;

        return Objects.equals(id, cvModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}