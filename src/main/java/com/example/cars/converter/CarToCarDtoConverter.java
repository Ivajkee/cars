package com.example.cars.converter;

import com.example.cars.dto.CarDto;
import com.example.cars.dto.ModelDto;
import com.example.cars.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarToCarDtoConverter implements Converter<Car, CarDto> {
    private final ConversionService conversionService;

    @Autowired
    public CarToCarDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public CarDto convert(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setModels(car.getModels()
                .stream()
                .map(model -> conversionService.convert(model, ModelDto.class))
                .collect(Collectors.toSet()));
        return carDto;
    }
}
