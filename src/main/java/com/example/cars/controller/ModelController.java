package com.example.cars.controller;

import com.example.cars.dto.ModelDto;
import com.example.cars.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ModelDto createModel(@RequestBody ModelDto modelDto) {
        return modelService.createModel(modelDto);
    }

    @GetMapping(value = "/{id}")
    public ModelDto getModelById(@PathVariable("id") Long id) {
        return modelService.getModelById(id);
    }
}
