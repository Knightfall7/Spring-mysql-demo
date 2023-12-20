package com.example.Spring_mysql_demo.repositories;

import com.example.Spring_mysql_demo.models.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {


}
