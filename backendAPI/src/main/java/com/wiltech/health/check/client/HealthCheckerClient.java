package com.wiltech.health.check.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiltech.health.check.EndPointStatusPayload;
import com.wiltech.health.check.HealthCheck;
import com.wiltech.health.check.HealthCheckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    /**
     * Gets health statuses.
     */
    public void getHealthStatuses() {

        HttpClient httpClient = generateClient();


        for (HealthStatusType healthCheck : HealthStatusType.values()) {
            HttpRequest request = generateRequest(healthCheck.getUrl());
            getHealthCheck(httpClient, request);
        }
    }

    private void getHealthCheck(HttpClient httpClient, HttpRequest request) {
        try {
            //get payload
            HttpResponse<String> talentResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info(talentResponse.body());
            if (talentResponse.statusCode() == 200) {
                EndPointStatusPayload payload = mapper.readValue(talentResponse.body(),
                        EndPointStatusPayload.class);

                repository.save(new HealthCheck(payload.getArtifactId(), payload.getGroupId(), payload.getArtifactId(), payload.getVersion(), payload.getBuildSHA()));
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
}
