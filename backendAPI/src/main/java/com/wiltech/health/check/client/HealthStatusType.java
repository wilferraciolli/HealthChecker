package com.wiltech.health.check.client;

/**
 * The enum Health status type.
 */
public enum HealthStatusType {
    /**
     * Talent health status type.
     */
    TALENT("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "TALENT"),

    /**
     * Admin health status type.
     */
    ADMIN("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "ADMIN"),
    /**
     * Pay health status type.
     */
    PAY("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "ADMIN"),
    /**
     * Calendar health status type.
     */
    CALENDAR("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "ADMIN"),
    /**
     * Recruitment health status type.
     */
    RECRUITMENT("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "RECRUITMENT"),
    /**
     * Learning health status type.
     */
    LEARNING("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "ADMIN"),
    /**
     * Social feed health status type.
     */
    SOCIAL_FEED("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "SOCIAL_FEED"),
    /**
     * Custom cards health status type.
     */
    CUSTOM_CARDS("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "CUSTOM_CARDS"),
    /**
     * Hrm health status type.
     */
    HRM("https://devint.eu.peoplefirst-dev.com/api/v1/talent/status", "HRM");

  private final String url;
  private final String deployment;

    HealthStatusType(String url, String deployment) {
        this.url = url;
        this.deployment = deployment;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets deployment.
     *
     * @return the deployment
     */
    public String getDeployment() {
        return deployment;
    }}
