/*
 * (c) Midland Software Limited 2019
 * Name     : ProfileRestService.java
 * Author   : ferraciolliw
 * Date     : 08 Mar 2019
 */
package com.wiltech.profile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiltech.health.check.HealthCheck;
import com.wiltech.health.check.HealthCheckRepository;
import com.wiltech.health.check.HealthCheckRestService;
import com.wiltech.health.check.client.HealthCheckerClient;

/**
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/profiles")
public class ProfileRestService {

    private Logger logger = LoggerFactory.getLogger(ProfileRestService.class);

    @Autowired
    private HealthCheckRepository repository;

    @Autowired
    private HealthCheckerClient healthCheckerClient;

    @GetMapping("/{id}")
    public List<HealthCheck> getStatusForProfile(@PathVariable("id") final Long id) {

        return repository.findByServerIdOrderByCreatedDateTimeDesc(id);
    }
}
