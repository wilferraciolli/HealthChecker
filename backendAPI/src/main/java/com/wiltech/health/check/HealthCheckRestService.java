package com.wiltech.health.check;

import com.wiltech.health.check.client.HealthCheckerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Health check rest service.
 */
@RestController
@CrossOrigin
@RequestMapping("/test")
public class HealthCheckRestService {

    @Autowired
    private HealthCheckRepository repository;

    @Autowired
    private HealthCheckerClient healthCheckerClient;

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<HealthCheck> getAll() {
       return  repository.findAll();
    }

    @GetMapping(value = "/refresh")
    public String refresh() {
        healthCheckerClient.getHealthStatuses();

        return "Refeshed";
    }

}
