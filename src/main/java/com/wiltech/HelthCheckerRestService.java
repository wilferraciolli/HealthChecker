package com.wiltech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping()
public class HelthCheckerRestService {

    @Autowired
    private HealthCheckRepository repository;

//    @GetMapping
//    public List<HealthCheck> getAll() {
//
//        return repository.findAll();
//    }

    @GetMapping("/test")
    public String getAlls() {

        return "Hello";
    }


}
