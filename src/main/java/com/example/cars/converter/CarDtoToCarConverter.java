package com.example.cars.converter;

import com.example.cars.dto.CarDto;
import com.example.cars.model.Car;
import com.example.cars.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
        carDto.getModels().forEach(modelDto -> car.addModel(conversionService.convert(modelDto, Model.class)));
        return car;
    }
}