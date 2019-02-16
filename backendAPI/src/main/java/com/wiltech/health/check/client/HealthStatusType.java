package com.wiltech.health.check.client;

/**
 * The enum Health status type.
 */
public enum HealthStatusType {

    /**
     * Talent health status type.
     */
    TALENT("https://devint.eu.peoplefirst-dev.com/api/v1/talent/servicestatus/healthcheck"),
    /**
     * Admin health status type.
     */
    ADMIN("https://devint.eu.peoplefirst-dev.com/api/v1/admin/servicestatus/healthcheck"),
    /**
     * Pay health status type.
     */
    PAY("https://devint.eu.peoplefirst-dev.com/api/v1/pay/servicestatus/healthcheck"),
    /**
     * Calendar health status type.
     */
    CALENDAR("https://devint.eu.peoplefirst-dev.com/api/v1/calendar/servicestatus/healthcheck"),
    /**
     * Recruitment health status type.
     */
    RECRUITMENT("https://devint.eu.peoplefirst-dev.com/api/v1/recruitment/servicestatus/healthcheck"),
    /**
     * Learning health status type.
     */
    LEARNING("https://devint.eu.peoplefirst-dev.com/api/v1/learning/servicestatus/healthcheck"),
    /**
     * Social feed health status type.
     */
    SOCIAL_FEED("https://devint.eu.peoplefirst-dev.com/api/v1/socialfeed/servicestatus/healthcheck"),
    /**
     * Hrm health status type.
     */
    HRM("https://devint.eu.peoplefirst-dev.com/api/v1/hrm/servicestatus/healthcheck");

  private final String url;

    HealthStatusType(String url) {
        this.url = url;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}