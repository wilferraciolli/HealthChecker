package com.wiltech.health.check;

import com.wiltech.health.check.client.HealthCheckerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Health check rest service.
 */
@RestController
@CrossOrigin
@RequestMapping("/servers")
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
//    @CrossOrigin
    @GetMapping("/{id}/healthchecks")
    public List<HealthCheck> getHealthChecksForServer(@PathVariable("id") final Long id) {

        // return Arrays.asList(HealthCheck.builder().name("Wil").serverId(1L).build());
        return repository.findByServerIdOrderByCreatedDateTimeDesc(id);
    }

    /**
     * Gets server overall.
     *
     * @param id the id
     * @return the server overall
     */
//    @CrossOrigin(value = "http://localhost:4200")
    @GetMapping("/{id}/overall")
    public Double getServerOverall(@PathVariable("id") final Long id) {
        List<HealthCheck> healthChecks = repository.findByServerIdOrderByCreatedDateTimeDesc(id);

        int successResponse = 0;
        for (HealthCheck healthCheck : healthChecks) {
            if (healthCheck.getResponseCode() == HttpStatus.OK.value()) {
                successResponse++;
            }
        }

        //retun the percentage of success rate
        return Double.valueOf(successResponse * 100 / healthChecks.size());
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
