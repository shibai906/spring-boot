package com.zhao.springboot.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.zhao.springboot.mybatis.redaccount.mapper"}, sqlSessionFactoryRef = "redPacketSqlSessionFactory")
public class RedAccountDataSourceConfiguration {
    /**
     * mybatis的xml文件.
     */
    public static final String MAPPER_XML_LOCATION = "com/zhao/springboot/mybatis/redaccount/mapper/*.xml";


    @Autowired
    @Qualifier("redPacketDataSource")
    DataSource redPacketDataSource;

    /**
     * 配置Sql Session模板
     */
    @Bean
    public SqlSessionTemplate redPacketSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(redPacketSqlSessionFactory());
    }

    /**
     * 配置SQL Session工厂
     */
    @Bean
    public SqlSessionFactory redPacketSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(redPacketDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return factoryBean.getObject();
    }


    /**
     *  配置事务
     */
    @Bean(name="accountTransactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(redPacketDataSource);
    }
}
