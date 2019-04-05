/*
 * (c) Midland Software Limited 2019
 * Name     : EnvironmentStatusChecker.java
 * Author   : ferraciolliw
 * Date     : 05 Apr 2019
 */
package com.wiltech.health.check.environment;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentStatusChecker {

    private String name;
    private Integer statusCode;
}
