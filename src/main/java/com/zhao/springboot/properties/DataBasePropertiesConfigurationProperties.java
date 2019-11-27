package com.zhao.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("database")    // 使用它都是通过set方法加载
public class DataBasePropertiesConfigurationProperties {

    private String driverName = null;

    private String url = null;

    private String username = null;

    private String password = null;

    public void setDriverName(String driverName) {
        System.out.println(driverName);
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        System.out.println(url);
        this.url = url;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public void setPassword(String password) {
        System.out.println(password);
        this.password = password;
    }
}
