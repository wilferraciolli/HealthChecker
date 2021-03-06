package com.wiltech.health.check;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * The type Health check.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long serverId;

    @NonNull
    private String name;

    private String groupId;

    private String artifactId;

    private String version;

    private String buildSHA;

    private Integer responseCode;

    private LocalDateTime createdDateTime;

}
