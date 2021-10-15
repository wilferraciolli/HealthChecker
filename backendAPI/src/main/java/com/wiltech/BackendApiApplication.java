package com.wiltech;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wiltech.health.check.client.HealthStatusDevIntType;
import com.wiltech.health.check.servers.ServerDescription;
import com.wiltech.health.check.servers.ServerDescriptionRepository;

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
        //Populate a list of servers if needed

        boolean needsCreating = repository.findAll().isEmpty();
        return args -> {
            if (needsCreating) {
                Stream.of(HealthStatusDevIntType.values()).forEach(statusType -> {
                    repository.save(ServerDescription.builder()
                            .name(statusType.name())
                            .deployment(statusType.getDeployment())
                            .build());
                });
            }

            repository.findAll().forEach(System.out::println);
        };
    }
}

