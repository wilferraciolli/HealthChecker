package com.wiltech.health.check;


import lombok.Data;

/**
 * The type End point status payload.
 */
@Data
public class EndPointStatusPayload {

    private String groupId;
    private String artifactId;
    private String version;
    private String buildSHA;

}
