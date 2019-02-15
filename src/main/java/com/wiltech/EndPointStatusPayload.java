/*
 * (c) Midland Software Limited 2019
 * Name     : EndPointStatusPayload.java
 * Author   : ferraciolliw
 * Date     : 15 Feb 2019
 */
package com.wiltech;

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
