package com.wiltech.health.check;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {

    List<HealthCheck> findByServerIdOrderByCreatedDateTimeDesc(Long serverId);
}
