package com.wiltech;

import com.wiltech.health.check.client.HealthStatusType;
import com.wiltech.health.check.servers.ServerDescription;
import com.wiltech.health.check.servers.ServerDescriptionRepository;
import lombok.val;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class BackendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }

    /**
     * Adding  ApplicationRunner bean to the Application Boot to run set up on start up.
     *
     * @param repository the repository
     * @return application runner
     */
    @Bean
    ApplicationRunner init(ServerDescriptionRepository repository) {
        //Populate a list of health checks on
        return args -> {
            Stream.of(HealthStatusType.values()).forEach(statusType -> {

                repository.save(ServerDescription.builder()
                        .name(statusType.name())
                        .overallPercentage(100)
                        .build());
            });

            //Print every car on the database
            repository.findAll().forEach(System.out::println);
        };
    }
}

