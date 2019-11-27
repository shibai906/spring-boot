package com.zhao.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaseProperties {

    // @Value在属性上面，是不走set方法的
    @Value("${database.driverName}")
    private String driverName = null;

    @Value("${database.url}")
    private String url = null;

    private String userName = null;
    private String password = null;

    public void setDriverName(String driverName) {
        System.out.println("driverName = " + driverName);
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        System.out.println("url = " + url);
        this.url = url;
    }

    // 在方法上，是走方法的
    @Value("${database.username}")
    public void setUserName(String userName) {
        System.out.println("userName = " + userName);
        this.userName = userName;
    }

    @Value("${database.password}")
    public void setPassword(String password) {
        System.out.println("password = " + password);
        this.password = password;
    }
}
