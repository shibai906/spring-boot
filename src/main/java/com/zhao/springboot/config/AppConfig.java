package com.zhao.springboot.config;

import com.zhao.springboot.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan  ( basePackages = ("com.zhao.springboot.*") ,excludeFilters = {@ComponentScan.Filter(classes = TestHaHa.class) })
@ComponentScan(basePackages = ("com.zhao"))
public class AppConfig {

    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(100);
        user.setUserName("赵欢");
        user.setNote("笔记");
        return user;
    }

}
