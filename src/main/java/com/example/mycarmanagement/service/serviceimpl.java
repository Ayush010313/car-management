package com.example.mycarmanagement.service;
import com.myproject.carmanagement.dto.CarDto;
import com.myproject.carmanagement.entity.Car;
import com.myproject.carmanagement.exception.CarNotFoundException;
import com.myproject.carmanagement.repository.CarRepository;
import com.myproject.carmanagement.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Page<Car> getAllCars(int pageNumber, int pageSize, String sortBy) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return carRepository.findAll(pageRequest);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
    }

    @Override
    public Car createCar(CarDto carDto) {
        Car car = new Car();
        BeanUtils.copyProperties(carDto, car);
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, CarDto carDto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
        BeanUtils.copyProperties(carDto, car);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
        carRepository.delete(car);
    }
}