package com.wiltech.health.check;

import com.wiltech.health.check.client.HealthCheckerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
     * Gets health checks for server.
     *
     * @param id the id
     * @return the health checks for server
     */
    @GetMapping
    public List<HealthCheck> getHealthChecksForServer(@PathVariable("id") final Long id) {

     // return Arrays.asList(HealthCheck.builder().name("Wil").serverId(1L).build());

      return  repository.findByServerId(id);
    }

    /**
     * Refresh string.
     *
     * @return the string
     */
    @GetMapping(value = "/refresh")
    public String refresh() {
        healthCheckerClient.getHealthStatuses();

        return "Refeshed";
    }

}
