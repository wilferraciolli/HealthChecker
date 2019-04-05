/*
 * (c) Midland Software Limited 2019
 * Name     : EnvironmentHealthCheck.java
 * Author   : ferraciolliw
 * Date     : 05 Apr 2019
 */
package com.wiltech.health.check.environment;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiltech.health.check.client.EnvironmentHealthCheckClient;
import com.wiltech.health.check.servers.ServerDescription;

@RestController
@CrossOrigin
@RequestMapping("/environment/status")
public class EnvironmentHealthCheckRestService {

    @Autowired
    private EnvironmentHealthCheckClient environmentHealthCheckClient;

    @GetMapping
    public List<Environment> getAll() {
        return environmentHealthCheckClient.getStatusForEnvironment();

    }
}
