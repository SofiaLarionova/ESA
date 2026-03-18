package ru.ssau.labs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ssau.labs.spring.model.CvModel;
import ru.ssau.labs.spring.service.CvModelService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/models")
public class CvModelController {

    private final CvModelService modelService;

    @Autowired
    public CvModelController(CvModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<CvModel> books = modelService.getAllSorted();
        model.addAttribute("models", books);
        return "models";
    }

    @PostMapping("/create")
    public String create(@RequestParam String modelName,
                         @RequestParam LocalDate releaseDate,
                         @RequestParam BigDecimal score) {
        modelService.create(modelName, releaseDate, score);
        return "redirect:/models";
    }

    @GetMapping("/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        CvModel cvModel = modelService.get(Math.toIntExact(id));
        model.addAttribute("model", cvModel);
        return "updateModel";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String modelName,
                         @RequestParam LocalDate releaseDate,
                         @RequestParam BigDecimal score) {
        modelService.update(id, modelName, releaseDate, score);
        return "redirect:/models";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        modelService.delete(id);
        return "redirect:/models";
    }
}