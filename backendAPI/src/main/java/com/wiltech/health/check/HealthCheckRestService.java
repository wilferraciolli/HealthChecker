package com.wiltech.health.check;

import com.wiltech.health.check.client.HealthCheckerClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Health check rest service.
 */
@RestController
@CrossOrigin
@RequestMapping("/servers")
public class HealthCheckRestService {
    private Logger logger = LoggerFactory.getLogger(HealthCheckRestService.class);

    @Autowired
    private HealthCheckRepository repository;

    @Autowired
    private HealthCheckerClient healthCheckerClient;

    /**
     * Gets health checks for server.
     * @param id the id
     * @return the health checks for server
     */
    @GetMapping("/{id}/healthchecks")
    public List<HealthCheck> getHealthChecksForServer(@PathVariable("id") final Long id) {

        return repository.findByServerIdOrderByCreatedDateTimeDesc(id);
    }

    /**
     * Gets server overall.
     * @param id the id
     * @return the server overall
     */
    @GetMapping("/{id}/overall")
    public Double getServerOverall(@PathVariable("id") final Long id) {
        List<HealthCheck> healthChecks = repository.findByServerIdOrderByCreatedDateTimeDesc(id);

        int successResponse = 0;
        for (HealthCheck healthCheck : healthChecks) {
            if (healthCheck.getResponseCode() == HttpStatus.OK.value()) {
                successResponse++;
            }
        }

        //return the percentage of success rate
        return Double.valueOf(successResponse * 100 / healthChecks.size());
    }

    @GetMapping("/{id}/currentstatus")
    public Integer getServeCurrentStatus(@PathVariable("id") final Long id) {
        List<HealthCheck> healthChecks = repository.findByServerIdOrderByCreatedDateTimeDesc(id);

        return healthChecks.get(0).getResponseCode();
    }

    @GetMapping("/{id}/versiondetails")
    public HealthCheck getServerVersionDetails(@PathVariable("id") final Long id) {
        try {
            List<HealthCheck> healthChecks = repository.findByServerIdOrderByCreatedDateTimeDesc(id);

            if (healthChecks.isEmpty() || !healthChecks.get(healthChecks.size() - 1).getResponseCode().equals(200)) {
                return buildUnknownHealthCheck(id);
            } else {
                return healthChecks.get(healthChecks.size() - 1);
            }
        } catch (Exception e) {
            logger.error(String.format("An Error occurred because %s, message %s ", e.getCause(), e.getMessage()));
            return buildUnknownHealthCheck(id);
        }
    }

    /**
     * Refresh string.
     * @return the string
     */
    @GetMapping(value = "/refresh")
    public String refresh() {
        healthCheckerClient.getHealthStatuses();
        return "Refreshed";
    }

    private HealthCheck buildUnknownHealthCheck(Long serverId) {
        return HealthCheck.builder()
                .serverId(serverId)
                .version("0")
                .responseCode(404)
                .createdDateTime(LocalDateTime.now())
                .name("Unknown")
                .build();
    }
}
