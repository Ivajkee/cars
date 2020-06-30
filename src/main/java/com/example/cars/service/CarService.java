package com.example.cars.service;

import com.example.cars.dto.CarDto;
import com.example.cars.model.Car;
import com.example.cars.model.Model;
import com.example.cars.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final ConversionService conversionService;

    @Autowired
    public CarService(CarRepository carRepository, ConversionService conversionService) {
        this.carRepository = carRepository;
        this.conversionService = conversionService;
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car is not found"));
        return conversionService.convert(car, CarDto.class);
    }

    @Override
    public List<CarDto> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> conversionService.convert(car, CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = conversionService.convert(carDto, Car.class);
        return conversionService.convert(carRepository.save(car), CarDto.class);
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        Car car = carRepository.findById(carDto.getId()).orElseThrow(() -> new RuntimeException("Car is not found"));
        car.setName(carDto.getName());
        car.setModels(carDto.getModelsDto().stream().map(modelDto -> conversionService.convert(modelDto, Model.class)).collect(Collectors.toSet()));
        return conversionService.convert(carRepository.save(car), CarDto.class);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car is not found"));
        carRepository.delete(car);
    }
}
