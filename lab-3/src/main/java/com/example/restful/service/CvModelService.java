package com.example.restful.service;

import com.example.restful.model.CvModel;
import com.example.restful.repository.CvModelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.restful.util.ValidationUtil.checkNotFoundWithId;

@Service
@Transactional
public class CvModelService {
    private final CvModelRepository cvModelRepository;

    public CvModelService(CvModelRepository cvModelRepository) {
        this.cvModelRepository = cvModelRepository;
    }

    public CvModel create(CvModel cvModel) {
        Assert.notNull(cvModel, "CvModel must not be null");
        return cvModelRepository.save(cvModel);
    }

    public CvModel update(long id, CvModel updatedModel) {
        Assert.notNull(updatedModel, "CvModel must not be null");
        return cvModelRepository.findById(id)
                .map(cvModel -> {
                    cvModel.setModelName(updatedModel.getModelName());
                    cvModel.setReleaseDate(updatedModel.getReleaseDate());
                    cvModel.setTop5Score(updatedModel.getTop5Score());
                    return cvModelRepository.save(cvModel);
                })
                .orElseThrow(() -> new RuntimeException("CvModel not found with id " + id));
    }

    public CvModel get(long id) {
        cvModelRepository.findById(id);
        return checkNotFoundWithId(cvModelRepository.findById(id), id);
    }

    public void delete(long id) {
        CvModel cvModel = get(id);
        cvModelRepository.delete(cvModel);
    }

    public List<CvModel> getAllSorted() {
        return cvModelRepository.getAllSortedByReleaseDateDesc();
    }
}