package com.example.cars.service;

import com.example.cars.dto.CarDto;

import java.util.List;

public interface ICarService {
    CarDto getCarById(Long id);

    List<CarDto> getAll();

    CarDto createCar(CarDto carDto);

    CarDto updateCar(CarDto carDto);

    void deleteCar(Long id);
}
