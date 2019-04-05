package com.wiltech.health.check.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wiltech.health.check.environment.Environment;
import com.wiltech.health.check.environment.EnvironmentHealthStatusType;
import com.wiltech.health.check.environment.EnvironmentStatusChecker;

/**
 * The type Health checker client.
 */
@Component
public class EnvironmentHealthCheckClient {

    private Logger logger = LoggerFactory.getLogger(EnvironmentHealthCheckClient.class);

    public List<Environment> getStatusForEnvironment() {

        HttpClient httpClient = generateClient();

        List<Environment> environments = getEnvironments();

        environments.stream()
                .forEach(environment -> {
                    for (EnvironmentHealthStatusType status : EnvironmentHealthStatusType.values()) {
                        HttpRequest request = generateRequest(formatUrl(status.getUrl(), environment));
                        EnvironmentStatusChecker environmentStatusChecker = EnvironmentStatusChecker.builder()
                                .name(status.name())
                                .statusCode(getHealthCheck(httpClient, request))
                                .build();
                        environment.getStatuses().add(environmentStatusChecker);
                    }
                });

        return environments;
    }

    private String formatUrl(String url, Environment environment) {
      logger.info(url + "?tec=" + environment.getTenantCode() + "-" + environment.getEnvironmentCode());
        return url + "?tec=" + environment.getTenantCode() + "-" + environment.getEnvironmentCode();
    }

    private Integer getHealthCheck(HttpClient httpClient, HttpRequest request) {
        try {
            //get payload
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info(response.body());
            return response.statusCode();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 1;
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

    private List<Environment> getEnvironments() {
        Environment env1 = Environment.builder()
                .id(1L)
                .tenantCode("DevEnv")
                .environmentCode("WilDev")
                .statuses(new ArrayList<>())
                .build();

        Environment env2 = Environment.builder()
                .id(1L)
                .tenantCode("Polaris")
                .environmentCode("Dev1")
                .statuses(new ArrayList<>())
                .build();
        Environment env3 = Environment.builder()
                .id(1L)
                .tenantCode("Polaris")
                .environmentCode("Sally1")
                .statuses(new ArrayList<>())
                .build();

        return Arrays.asList(env1, env2, env3);
    }

}


