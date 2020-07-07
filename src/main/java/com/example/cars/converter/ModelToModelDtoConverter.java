package com.example.cars.converter;

import com.example.cars.dto.ModelDto;
import com.example.cars.model.Model;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToModelDtoConverter implements Converter<Model, ModelDto> {

    @Override
    public ModelDto convert(Model model) {
        ModelDto modelDto = new ModelDto();
        modelDto.setId(model.getId());
        modelDto.setCarName(model.getCar().getName());
        modelDto.setModel(model.getModel());
        modelDto.setYear(model.getYear());
        modelDto.setColor(model.getColor());
        return modelDto;
    }
}
