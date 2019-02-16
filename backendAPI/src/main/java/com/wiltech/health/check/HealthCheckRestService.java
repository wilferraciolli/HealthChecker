package com.wiltech.health.check;

import com.wiltech.health.check.client.HealthCheckerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The type Health check rest service.
 */
@RestController
@CrossOrigin
@RequestMapping("/servers/{id}/healthchecks")
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
    @GetMapping("/{id}")
    public List<HealthCheck> getHealthChecksForServer(@PathVariable("id") final UUID id) {
       return  repository.findByServerId(id);
    }

    @GetMapping(value = "/refresh")
    public String refresh() {
        healthCheckerClient.getHealthStatuses();

        return "Refeshed";
    }

}
