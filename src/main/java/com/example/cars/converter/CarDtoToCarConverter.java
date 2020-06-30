package com.example.cars.converter;

import com.example.cars.dto.CarDto;
import com.example.cars.model.Car;
import com.example.cars.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarDtoToCarConverter implements Converter<CarDto, Car> {
    private final ConversionService conversionService;

    @Autowired
    public CarDtoToCarConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Car convert(CarDto carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setModels(carDto.getModelsDto().stream().map(modelDto -> conversionService.convert(modelDto, Model.class)).collect(Collectors.toSet()));
        return car;
    }
}
