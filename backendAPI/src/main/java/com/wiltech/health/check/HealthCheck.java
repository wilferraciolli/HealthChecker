package com.wiltech.health.check;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @NonNull
    @Type(type ="uuid")
    private UUID serverId;

    @NonNull
    private  String name;

    private String groupId;

    private String artifactId;

    private String version;

    private String buildSHA;

    private Integer responseCode;

}