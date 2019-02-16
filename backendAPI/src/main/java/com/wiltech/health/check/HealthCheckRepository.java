package com.wiltech.health.check;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {

    List<HealthCheck> findByServerId(Long serverId);
}
