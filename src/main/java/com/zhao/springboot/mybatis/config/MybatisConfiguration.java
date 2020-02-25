package com.zhao.springboot.mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 */
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfiguration {
    /**
     * account数据库配置前缀.
     */
    final static String ACCOUNT_PREFIX = "spring.datasource.druid.account";
    /**
     * redpacket数据库配置前缀.
     */
    final static String REDPACKET_PREFIX = "spring.datasource.druid.redpacket";

    /**
     * 配置Account数据库的数据源
     *
     * @return the data source
     */
    @Bean(name = "accountDataSource")
    @ConfigurationProperties(prefix = ACCOUNT_PREFIX)  // application.properties中对应属性的前缀
    public DataSource accountDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 配置RedPacket数据库的数据源
     *
     * @return the data source
     */
    @Bean(name = "redPacketDataSource")
    @ConfigurationProperties(prefix = REDPACKET_PREFIX)  // application.properties中对应属性的前缀
    public DataSource redPacketDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
