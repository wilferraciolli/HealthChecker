package com.wiltech.health.check.client;

/**
 * The enum Health status type.
 */
public enum HealthStatusDevIntType {

    TALENT_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/talent/servicestatus/healthcheck", "TALENT"),
    TALENT_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/talent/servicestatus/healthcheck", "TALENT"),
    TALENT_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/talent/servicestatus/healthcheck", "TALENT"),
    TALENT_PROD("https://eu.people-first.com/api/v1/talent/servicestatus/healthcheck", "TALENT"),

    GOALS_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/goals/servicestatus/healthcheck", "TALENT"),
    GOALS_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/goals/servicestatus/healthcheck", "TALENT"),
    GOALS_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/goals/servicestatus/healthcheck", "TALENT"),
    GOALS_PROD("https://eu.people-first.com/api/v1/goals/servicestatus/healthcheck", "TALENT"),

    LEARNING_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/learning/servicestatus/healthcheck", "ADMIN"),
    LEARNING_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/learning/servicestatus/healthcheck", "ADMIN"),
    LEARNING_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/learning/servicestatus/healthcheck", "ADMIN"),
    LEARNING_PROD("https://eu.people-first.com/api/v1/learning/servicestatus/healthcheck", "ADMIN"),

    PAY_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/pay/servicestatus/healthcheck", "ADMIN"),
    PAY_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/pay/servicestatus/healthcheck", "ADMIN"),
    PAY_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/pay/servicestatus/healthcheck", "ADMIN"),
    PAY_PROD("https://eu.people-first.com/api/v1/pay/servicestatus/healthcheck", "ADMIN"),

    CALENDAR_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/calendar/servicestatus/healthcheck", "ADMIN"),
    CALENDAR_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/calendar/servicestatus/healthcheck", "ADMIN"),
    CALENDAR_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/calendar/servicestatus/healthcheck", "ADMIN"),
    CALENDAR_PROD("https://eu.people-first.com/api/v1/calendar/servicestatus/healthcheck", "ADMIN"),

    ADMIN_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/admin/servicestatus/healthcheck", "ADMIN"),
    ADMIN_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/admin/servicestatus/healthcheck", "ADMIN"),
    ADMIN_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/admin/servicestatus/healthcheck", "ADMIN"),
    ADMIN_PROD("https://eu.people-first.com/api/v1/admin/servicestatus/healthcheck", "ADMIN"),

    RECRUITMENT_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/recruitment/servicestatus/healthcheck", "RECRUITMENT"),
    RECRUITMENT_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/recruitment/servicestatus/healthcheck", "RECRUITMENT"),
    RECRUITMENT_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/recruitment/servicestatus/healthcheck", "RECRUITMENT"),
    RECRUITMENT_PROD("https://eu.people-first.com/api/v1/recruitment/servicestatus/healthcheck", "RECRUITMENT"),

    SOCIAL_FEED_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/socialfeed/servicestatus/healthcheck", "SOCIAL_FEED"),
    SOCIAL_FEED_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/socialfeed/servicestatus/healthcheck", "SOCIAL_FEED"),
    SOCIAL_FEED_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/socialfeed/servicestatus/healthcheck", "SOCIAL_FEED"),
    SOCIAL_FEED_PROD("https://eu.people-first.com/api/v1/socialfeed/servicestatus/healthcheck", "SOCIAL_FEED"),

    CUSTOM_CARDS_DEVINT("https://devint.eu.peoplefirst-dev.com/api/v1/customcards/servicestatus/healthcheck", "CUSTOM_CARDS"),
    CUSTOM_CARDS_QA("https://pf-webui-qa-eun-app.azurewebsites.net/api/v1/customcards/servicestatus/healthcheck", "CUSTOM_CARDS"),
    CUSTOM_CARDS_PRE_PROD("https://preprod.eu.peoplefirst-dev.com/api/v1/customcards/servicestatus/healthcheck", "CUSTOM_CARDS"),
    CUSTOM_CARDS_PROD("https://eu.people-first.com/api/v1/customcards/servicestatus/healthcheck", "CUSTOM_CARDS"),

    /**
     * Hrm health status type.
     */
    HRM("https://devint.eu.peoplefirst-dev.com/api/v1/hrm/servicestatus/healthcheck", "HRM");

  private final String url;
  private final String deployment;

    HealthStatusDevIntType(String url, String deployment) {
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
