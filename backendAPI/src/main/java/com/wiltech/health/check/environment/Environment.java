/*
 * (c) Midland Software Limited 2019
 * Name     : Environment.java
 * Author   : ferraciolliw
 * Date     : 05 Apr 2019
 */
package com.wiltech.health.check.environment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String tenantCode;

    @NonNull
    private String environmentCode;

    List<EnvironmentStatusChecker> statuses = new ArrayList<>();

}
