package com.example.jms.controller;

import com.example.jms.model.CvModel;
import com.example.jms.service.CvModelService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/models",
        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
)
public class CvModelController {
    private final CvModelService cvModelService;

    public CvModelController(CvModelService cvModelService) {
        this.cvModelService = cvModelService;
    }

    @GetMapping
    public List<CvModel> getCvModels() {
        return cvModelService.getAllSorted();
    }

    @GetMapping("/{id}")
    public CvModel getCvModel(@PathVariable long id) {
        return cvModelService.get(id);
    }

    @PostMapping
    public CvModel addCvModel(@RequestBody CvModel cvModel) {
        return cvModelService.create(cvModel);
    }

    @PutMapping("/{id}")
    public CvModel updateCvModel(@PathVariable long id, @RequestBody CvModel cvModel) {
        return cvModelService.update(id, cvModel);
    }

    @DeleteMapping("/{id}")
    public void deleteCvModel(@PathVariable long id) {
        cvModelService.delete(id);
    }
}