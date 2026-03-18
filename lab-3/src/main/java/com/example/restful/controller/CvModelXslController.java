package com.example.restful.controller;

import com.example.restful.model.CvModel;
import com.example.restful.service.CvModelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.List;

@Controller
@RequestMapping(
        value = "/models/xsl"
)
public class CvModelXslController {
    private final CvModelService cvModelService;
    private final XmlMapper xmlMapper;

    public CvModelXslController(CvModelService cvModelService, XmlMapper xmlMapper) {
        this.cvModelService = cvModelService;
        this.xmlMapper = xmlMapper;
    }

    @GetMapping
    public ModelAndView getCvModelXsl() throws JsonProcessingException {
        List<CvModel> cvModels = cvModelService.getAllSorted();
        String xmlContent = xmlMapper.writeValueAsString(cvModels);

        StreamSource source = new StreamSource(new StringReader(xmlContent));

        ModelAndView modelAndView = new ModelAndView("models"); // Имя шаблона XSLT
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getCvModelsXsl(@PathVariable long id) throws JsonProcessingException {
        CvModel cvModel = cvModelService.get(id);
        String xmlContent = xmlMapper.writeValueAsString(cvModel);

        StreamSource source = new StreamSource(new StringReader(xmlContent));

        ModelAndView modelAndView = new ModelAndView("model"); // Имя шаблона XSLT
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}