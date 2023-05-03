package com.example.mycarmanagement.service;

import com.myproject.carmanagement.dto.CarDto;

import java.util.List;

public class CarService {
    List<CarDto> getAllCars();
    CarDto getCarById(Long id);
    CarDto createCar(CarDto carDto);
    CarDto updateCar(Long id, CarDto carDto);
    void deleteCar(Long id);
}
