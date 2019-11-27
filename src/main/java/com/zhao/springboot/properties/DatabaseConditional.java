package com.zhao.springboot.properties;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.sql.DataSource;
import java.util.Properties;

public class DatabaseConditional implements Condition {

    @Profile("dev") // 可以切换不同的环境，了解就行
    public DataSource getDataSource(@Value("${database.driverName}") String driver, @Value("${database.url}") String url,
                                    @Value("${database.username}") String userName, @Value("${database.password}") String password) {
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", userName);
        properties.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;

    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        return environment.containsProperty("database.driverName") && environment.containsProperty("database.url")
                && environment.containsProperty("database.username") && environment.containsProperty("database.password");
    }
}
