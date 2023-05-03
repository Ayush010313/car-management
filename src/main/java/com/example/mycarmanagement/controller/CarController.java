package com.example.mycarmanagement.controller;

import com.myproject.carmanagement.dto.CarDto;
import com.myproject.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        CarDto car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Validated @RequestBody CarDto carDto) {
        CarDto createdCar = carService.createCar(carDto);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Validated @RequestBody CarDto carDto) {
        CarDto updatedCar = carService.updateCar(id, carDto);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
