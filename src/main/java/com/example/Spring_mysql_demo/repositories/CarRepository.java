package com.example.Spring_mysql_demo.repositories;

import com.example.Spring_mysql_demo.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
