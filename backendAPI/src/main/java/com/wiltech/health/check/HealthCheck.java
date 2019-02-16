package com.wiltech.health.check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Health check.
 */
@Data
@NoArgsConstructor
@Entity
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private  String name;

    private String groupId;

    private String artifactId;

    private String version;

    private String buildSHA;

    public HealthCheck(@NonNull String name, String groupId, String artifactId, String version, String buildSHA) {
        this.name = name;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.buildSHA = buildSHA;
    }
}
