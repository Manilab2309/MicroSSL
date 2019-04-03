/**
 * SPRING API SECURITY CONFIGURATION
 */
package com.msc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sec")
public class MicroCoreSecurityConfiguration {

    private String userAPIAllowed;
    private String passAPIAllowed;
    private String key;
    private String initVector;
    private CharSequence saltpre;
    private CharSequence saltpost;

    public String getUserAPIAllowed() {
        return userAPIAllowed;
    }

    public void setUserAPIAllowed(String userAPIAllowed) {
        this.userAPIAllowed = userAPIAllowed;
    }

    public String getPassAPIAllowed() {
        return passAPIAllowed;
    }

    public void setPassAPIAllowed(String passAPIAllowed) {
        this.passAPIAllowed = passAPIAllowed;
    }

    public String getInitVector() {
        return initVector;
    }

    public void setInitVector(String initVector) {
        this.initVector = initVector;
    }

    public CharSequence getSaltpre() {
        return saltpre;
    }

    public void setSaltpre(CharSequence saltpre) {
        this.saltpre = saltpre;
    }

    public CharSequence getSaltpost() {
        return saltpost;
    }

    public void setSaltpost(CharSequence saltpost) {
        this.saltpost = saltpost;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}