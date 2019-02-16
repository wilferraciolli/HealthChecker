package com.wiltech.health.check;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, UUID> {

    List<HealthCheck> findByServerId(UUID serverId);
}
