package com.example.springboot_DataIntegrityViolation_Exception;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserController {

    @Autowired
    UserRepository urepo;

    @RequestMapping("/test")
    public String test()
    {
        return "Hello! This is Data Integrity Violation Exception springboot application ";
    }

    @PostMapping("/save")
    public String saveData(@Valid @RequestBody User user)
    {
        urepo.save(user);
        return "Data saved";
    }

    @GetMapping("/all")
    public List<User> allData()
    {
        return urepo.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<User> byId(@PathVariable int id)throws IdNotFoundException
    {
        Optional<User> users=urepo.findById(id);
        if(users.isEmpty()){
            throw new IdNotFoundException("No User Found By Id:" +id);
        }
        return users;
    }

}
