package ru.ssau.labs.service;

import ru.ssau.labs.models.CvModel;
import ru.ssau.labs.repository.CvModelStorage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CvModelService {

    private final CvModelStorage cvModelStorage;

    public CvModelService(CvModelStorage cvModelStorage) {
        this.cvModelStorage = cvModelStorage;
    }

    public void clear() {
        cvModelStorage.clear();
    }

    public void save(String name, Date release, BigDecimal score) {
        cvModelStorage.save(new CvModel(name, release, score));
    }

    public void update(Integer id, String name, Date release, BigDecimal score) {
        cvModelStorage.update(new CvModel(id, name, release, score));
    }

    public CvModel get(Integer id) {
        return cvModelStorage.get(id);
    }

    public void delete(Integer id) {
        cvModelStorage.delete(id);
    }

    public List<CvModel> getAllSorted() {
        return cvModelStorage.getAllSorted();
    }

    int size() {
        return cvModelStorage.size();
    }
}