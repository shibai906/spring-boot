package com.zhao.springboot;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class ApplicationTests {

    private static Logger log = Logger.getLogger(String.valueOf(ApplicationTests.class));

    @Test
    void contextLoads() {
        System.out.println("test加载");
    }

//    @Test
//    public void testLoad() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//  /*      TestHaHa user = context.getBean(TestHaHa.class);
//        System.out.println(user);
//        log.info(user.toString());*/
//    }
    @Test
    public void testLoadAinal() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        AllPerson allPerson = context.getBean(AllPerson.class);
//        allPerson.service();
//        System.out.println(allPerson);
//        allPerson = context.getBean(AllPerson.class);
//        allPerson.service();
//        System.out.println(allPerson);
//        allPerson = context.getBean(AllPerson.class);
//        System.out.println(allPerson);
//        allPerson.service();
//        context.close();
    }



}
