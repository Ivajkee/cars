package com.example.cars.service;

import com.example.cars.dto.ModelDto;

import java.util.List;

public interface IModelService {
    ModelDto getModelById(Long id);

    List<ModelDto> getAll();

    ModelDto createModel(ModelDto modelDto);

    ModelDto updateModel(ModelDto modelDto);

    void deleteModel(Long id);
}
