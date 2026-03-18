package com.example.restful.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "models", indexes = @Index(name = "models_name_uindex", columnList = "model_name", unique = true))
public class CvModel extends AbstractBaseEntity {

    @Column(name = "model_name", nullable = false, unique = true, length = 255)
    private String modelName;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    @Column(name = "top5_score", precision = 5, scale = 4)
    private BigDecimal top5Score;

    public CvModel(Long id, String modelName, LocalDate releaseDate, BigDecimal top5Score) {
        super(id);
        this.modelName = modelName;
        this.releaseDate = releaseDate;
        this.top5Score = top5Score;
    }

    public CvModel(String modelName, LocalDate releaseDate, BigDecimal top5Score) {
        this.modelName = modelName;
        this.releaseDate = releaseDate;
        this.top5Score = top5Score;
    }

    public CvModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getTop5Score() {
        return top5Score;
    }

    public void setTop5Score(BigDecimal top5Score) {
        this.top5Score = top5Score;
    }

    @Override
    public String toString() {
        return "CvModel{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", releaseDate=" + releaseDate +
                ", top5Score=" + top5Score +
                '}';
    }
}