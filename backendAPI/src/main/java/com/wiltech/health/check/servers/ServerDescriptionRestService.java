package com.wiltech.health.check.servers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/servers")
public class ServerDescriptionRestService {

    @Autowired
    private ServerDescriptionRepository repository;

    @GetMapping
    public List<ServerDescription> getAll() {

        List<ServerDescription> servers = repository.findAll();
        servers.stream().forEach(
                server -> {
                    server.setPrimaryDeployment(server.getName().equals(server.getDeploymnet()));
                    server.addLink(new Link("localhost:5001/api/servers/" + server.getId() + "/healthchecks", "healthStatusChecker"));
                    server.addLink(new Link("localhost:5001/api/servers/" + server.getId() + "/overall", "overall"));
                }
        );

        return servers;
    }
}
