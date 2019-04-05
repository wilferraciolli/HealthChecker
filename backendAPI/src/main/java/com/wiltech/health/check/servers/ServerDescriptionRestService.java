package com.wiltech.health.check.servers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import com.wiltech.health.check.HealthCheck;
import com.wiltech.health.check.HealthCheckRepository;

@RestController
@CrossOrigin
@RequestMapping("/servers")
public class ServerDescriptionRestService {

    @Autowired
    private ServerDescriptionRepository repository;

    @Autowired
    private HealthCheckRepository healtCheckRepo;

    @GetMapping
    public List<ServerDescription> getAll() {

        List<ServerDescription> servers = repository.findAll();
        servers.stream().forEach(
                server -> {
                    server.setPrimaryDeployment(server.getName().equals(server.getDeployment()));
                    server.setCurrentStatus(resolveCurrentStatus(server.getId()));
                    server.addLink(new Link("localhost:5001/api/servers/" + server.getId() + "/healthchecks", "healthStatusChecker"));
                    server.addLink(new Link("localhost:5001/api/servers/" + server.getId() + "/overall", "overall"));
                    server.addLink(new Link("localhost:5001/api/servers/" + server.getId() + "/versiondetails", "versionDetails"));
                }
        );

        return servers;
    }

    public Integer resolveCurrentStatus(Long serverId) {
        List<HealthCheck> healthChecks = healtCheckRepo.findByServerIdOrderByCreatedDateTimeDesc(serverId);
        if (!healthChecks.isEmpty() && Objects.nonNull(healthChecks.get(0))) {

            return healthChecks.get(0).getResponseCode();
        } else {
            return 1;
        }
    }
}
