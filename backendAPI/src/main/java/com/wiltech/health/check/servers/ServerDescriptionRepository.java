package com.wiltech.health.check.servers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServerDescriptionRepository extends JpaRepository<ServerDescription, UUID> {

    Optional<ServerDescription> findByName(String name);
}
