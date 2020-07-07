package com.example.cars.converter;

import com.example.cars.dto.ModelDto;
import com.example.cars.model.Car;
import com.example.cars.model.Model;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelDtoToModelConverter implements Converter<ModelDto, Model> {

    @Override
    public Model convert(ModelDto modelDto) {
        Model model = new Model();
        model.setModel(modelDto.getModel());
        model.setYear(modelDto.getYear());
        model.setColor(modelDto.getColor());
        return model;
    }
}