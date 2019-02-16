package com.wiltech;

import lombok.Data;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Data
@Entity
public class HealthCheck {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private  String name;

    private String groupId;

    private String artifactId;

    private String version;

    private String buildSHA;
}
