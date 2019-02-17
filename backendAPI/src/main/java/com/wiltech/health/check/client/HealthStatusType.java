package com.wiltech.health.check.client;

/**
 * The enum Health status type.
 */
public enum HealthStatusType {

    /**
     * Talent health status type.
     */
    TALENT("https://devint.eu.peoplefirst-dev.com/api/v1/talent/servicestatus/healthcheck", "TALENT"),
    /**
     * Admin health status type.
     */
    ADMIN("https://devint.eu.peoplefirst-dev.com/api/v1/admin/servicestatus/healthcheck", "ADMIN"),
    /**
     * Pay health status type.
     */
    PAY("https://devint.eu.peoplefirst-dev.com/api/v1/pay/servicestatus/healthcheck", "ADMIN"),
    /**
     * Calendar health status type.
     */
    CALENDAR("https://devint.eu.peoplefirst-dev.com/api/v1/calendar/servicestatus/healthcheck", "ADMIN"),
    /**
     * Recruitment health status type.
     */
    RECRUITMENT("https://devint.eu.peoplefirst-dev.com/api/v1/recruitment/servicestatus/healthcheck", "RECRUITMENT"),
    /**
     * Learning health status type.
     */
    LEARNING("https://devint.eu.peoplefirst-dev.com/api/v1/learning/servicestatus/healthcheck", "ADMIN"),
    /**
     * Social feed health status type.
     */
    SOCIAL_FEED("https://devint.eu.peoplefirst-dev.com/api/v1/socialfeed/servicestatus/healthcheck", "SOCIAL_FEED"),
    /**
     * Custom cards health status type.
     */
    CUSTOM_CARDS("https://devint.eu.peoplefirst-dev.com/api/v1/socialfeed/servicestatus/healthcheck", "CUSTOM_CARDS"),
    /**
     * Hrm health status type.
     */
    HRM("https://devint.eu.peoplefirst-dev.com/api/v1/hrm/servicestatus/healthcheck", "HRM");

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