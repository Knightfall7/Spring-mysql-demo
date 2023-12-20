package com.example.Spring_mysql_demo.controller;


import com.example.Spring_mysql_demo.models.Car;
import com.example.Spring_mysql_demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class CarController {
    @Autowired
    private CarRepository carRepository;

 @GetMapping("{/{id}")
    public Car read(@PathVariable int id){
    var optionalCar = carRepository.findById(id);
    return optionalCar.orElse(null);
 }

 @PostMapping("{/")
    public Car create(@RequestBody Car car) {
     carRepository.save(car);
     return car;

 }
}


