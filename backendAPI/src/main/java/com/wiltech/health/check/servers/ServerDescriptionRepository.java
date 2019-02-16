package com.wiltech.health.check.servers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServerDescriptionRepository extends JpaRepository<ServerDescription, Long> {

    Optional<ServerDescription> findByName(String name);
}
