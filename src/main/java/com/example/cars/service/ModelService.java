package com.example.cars.service;

import com.example.cars.dto.ModelDto;
import com.example.cars.model.Model;
import com.example.cars.repo.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModelService implements IModelService {
    private final ModelRepository modelRepository;
    private final ConversionService conversionService;

    @Autowired
    public ModelService(ModelRepository modelRepository, ConversionService conversionService) {
        this.modelRepository = modelRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ModelDto getModelById(Long id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("Model is not found"));
        return conversionService.convert(model, ModelDto.class);
    }

    @Override
    public List<ModelDto> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(cart -> conversionService.convert(cart, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto createModel(ModelDto modelDto) {
        Model model = conversionService.convert(modelDto, Model.class);
        return conversionService.convert(modelRepository.save(model), ModelDto.class);
    }

    @Override
    public ModelDto updateModel(ModelDto modelDto) {
        Model model = modelRepository.findById(modelDto.getId()).orElseThrow(() -> new RuntimeException("Model is not found"));
        model.setModel(modelDto.getModel());
        model.setYear(modelDto.getYear());
        model.setColor(modelDto.getColor());
        model.setCar(modelDto.getCar());
        return conversionService.convert(modelRepository.save(model), ModelDto.class);
    }

    @Override
    public void deleteModel(Long id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("Model is not found"));
        modelRepository.delete(model);
    }
}
