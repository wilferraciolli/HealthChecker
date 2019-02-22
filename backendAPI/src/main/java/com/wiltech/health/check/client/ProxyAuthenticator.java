/*
 * (c) Midland Software Limited 2019
 * Name     : ProxyAuthenticator.java
 * Author   : ferraciolliw
 * Date     : 22 Feb 2019
 */
package com.wiltech.health.check.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * The type Proxy authenticator.
 */
public class ProxyAuthenticator extends Authenticator {

    private final String user;
    private final String password;

    /**
     * This class allows an application to provide user authentication through a
     * proxy server.
     * @param user The username.
     * @param password The password.
     */
    public ProxyAuthenticator(final String user, final String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}
