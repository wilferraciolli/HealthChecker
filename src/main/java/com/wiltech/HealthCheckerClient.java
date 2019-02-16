/*
 * (c) Midland Software Limited 2019
 * Name     : HealthCheckerClient.java
 * Author   : ferraciolliw
 * Date     : 15 Feb 2019
 */
package com.wiltech;

import org.asynchttpclient.Request;
import org.asynchttpclient.util.HttpConstants;
import org.springframework.test.web.servlet.RequestBuilder;


/**
 *
 */
//@Stateless
public class HealthCheckerClient {

    Request getRequest = new RequestBuilder(HttpConstants.Methods.GET)
            .setUrl("http://www.baeldung.com")
            .build();
}
