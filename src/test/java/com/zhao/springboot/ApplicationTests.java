package com.zhao.springboot;

import com.zhao.springboot.config.AppConfig;
import com.zhao.springboot.config.TestHaHa;
import com.zhao.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootTest
class ApplicationTests {

    private static Logger log = Logger.getLogger(String.valueOf(ApplicationTests.class));

    @Test
    void contextLoads() {
        System.out.println("test加载");
    }

    @Test
    public void testLoad() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestHaHa user = context.getBean(TestHaHa.class);
        System.out.println(user);
        log.info(user.toString());
    }

}
