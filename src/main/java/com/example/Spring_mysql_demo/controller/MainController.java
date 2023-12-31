package com.example.Spring_mysql_demo.controller;

import com.example.Spring_mysql_demo.models.User;
import com.example.Spring_mysql_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        userRepository.save(user);
        return "Saved user";
    }
        @PutMapping(path = "/update/{id}")
        public @ResponseBody String updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email){
            var optionalUser = userRepository.findById(id);

            if(optionalUser.isEmpty())
            {
                return "NOT FOUND";
            }

            var user = optionalUser.get();

            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);

            return "Updated";
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}