package com.wiltech.health.check;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class HealthCheckRestService {

    @GetMapping
    public String getAll() {

        return "Hi";
    }

}
