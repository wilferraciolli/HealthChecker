package com.wiltech.health.check.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiltech.health.check.EndPointStatusPayload;
import com.wiltech.health.check.HealthCheck;
import com.wiltech.health.check.HealthCheckRepository;
import com.wiltech.health.check.servers.ServerDescriptionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The type Health checker client.
 */
@Component
public class HealthCheckerClient {

    private Logger logger = LoggerFactory.getLogger(HealthCheckerClient.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private HealthCheckRepository repository;

    @Autowired
    private ServerDescriptionRepository serverDescriptionRepository;

    /**
     * Gets health statuses.
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void getHealthStatuses() {

        setProxyDetails();

        HttpClient httpClient = generateClient();

        for (HealthStatusType healthCheck : HealthStatusType.values()) {
            HttpRequest request = generateRequest(healthCheck.getUrl());
            getHealthCheck(httpClient, request, healthCheck);
        }
    }

    private void getHealthCheck(HttpClient httpClient, HttpRequest request, HealthStatusType healthCheckType) {
        try {
            //get payload
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info(response.body());
            if (response.statusCode() == HttpStatus.OK.value()) {
                EndPointStatusPayload payload = mapper.readValue(response.body(),
                        EndPointStatusPayload.class);

                repository.save(HealthCheck.builder()
                        .serverId(serverDescriptionRepository.findByName(healthCheckType.name()).get().getId())
                        .name(healthCheckType.name())
                        .artifactId(payload.getArtifactId())
                        .buildSHA(payload.getBuildSHA())
                        .groupId(payload.getGroupId())
                        .responseCode(LocalDateTime.now().getSecond() % 2 == 0 ? HttpStatus.OK.value() : HttpStatus.BAD_REQUEST.value())
                        .createdDateTime(LocalDateTime.now())
                        .build());

            } else {
                logger.warn("Could not get a 200 on %s healthc check", healthCheckType.name());
                repository.save(HealthCheck.builder()
                        .serverId(serverDescriptionRepository.findByName(healthCheckType.name()).get().getId())
                        .name(healthCheckType.name())
                        .responseCode(response.statusCode())
                        .createdDateTime(LocalDateTime.now())
                        .build());
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private HttpRequest generateRequest(String s) {
        return HttpRequest.newBuilder()
                .uri(URI.create(s))
                .GET()   // this is the default
                .build();
    }

    private HttpClient generateClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // this is the default
                .build();
    }

    ///get values async
    //        httpClient.sendAsync(talentRequest, HttpResponse.BodyHandlers.ofString())
    //                .thenAccept(responseBody -> {
    //                            System.out.println(responseBody.body());
    //                        }
    //                );

    //        logger.info("Response status code: " + response.statusCode());
    //        logger.info("Response headers: " + response.headers());
    //        logger.info("Response body: " + response.body());

    // System.out.println(response.body());

    private static void setProxyDetails() {
        // set the wildfly system properties values
        System.setProperty("http.proxyHost", "msl-svr135");
        System.setProperty("http.proxyPort", "3128");
        System.setProperty("https.proxyHost", "msl-svr135");
        System.setProperty("https.proxyPort", "3128");

        // set username and password for the proxy
        Authenticator.setDefault(new ProxyAuthenticator("proxy", "TestProxy"));
    }

}


