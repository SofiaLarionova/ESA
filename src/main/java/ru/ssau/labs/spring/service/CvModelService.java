package ru.ssau.labs.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.ssau.labs.spring.model.CvModel;
import ru.ssau.labs.spring.repository.EntityRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static ru.ssau.labs.spring.util.ValidationUtil.checkNotFoundWithId;


@Service
public class CvModelService {
    private final EntityRepository<CvModel> cvModelRepository;

    public CvModelService(EntityRepository<CvModel> cvModelRepository) {
        this.cvModelRepository = cvModelRepository;
    }

    public void create(String modelName, LocalDate releaseDate, BigDecimal score) {
        cvModelRepository.save(new CvModel(modelName, releaseDate, score));
    }

    public void update(Long id, String modelName, LocalDate releaseDate, BigDecimal score) {
        Assert.notNull(id, "CvModel id must not be null");
        cvModelRepository.save(new CvModel(id, modelName, releaseDate, score));
    }

    public CvModel get(long id) {
        return checkNotFoundWithId(cvModelRepository.get(id), id);
    }

    public void delete(long id) {
        checkNotFoundWithId(cvModelRepository.delete(id), id);
    }

    public List<CvModel> getAllSorted() {
        return cvModelRepository.getAllSorted();
    }

}