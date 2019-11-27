package com.zhao.springboot;

import com.zhao.springboot.Intercept.MyIntercept;
import com.zhao.springboot.config.AppConfig;
import com.zhao.springboot.config.TestHaHa;
import com.zhao.springboot.di.imp.AllPerson;
import com.zhao.springboot.di.imp.BussinessPerson;
import com.zhao.springboot.di.imp.HelloServiceImpl;
import com.zhao.springboot.di.inter.HelloService;
import com.zhao.springboot.model.User;
import com.zhao.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    @Test
    public void testProxyBean() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        HelloService helloService = new HelloServiceImpl();
        // 按照约定执行proxy
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService , new MyIntercept());
        proxy.sayHello("zhaohuan");
        System.out.println("*****************************");
        proxy.sayHello("");
    }

    @Test
    public void testMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        HelloService helloService = new HelloServiceImpl();
        Method method = helloService.getClass().getDeclaredMethod("sayHello", String.class);
        method.invoke(helloService,"String.class)");
    }

    @Test
    public void testTransaction() {
        UserService service = new UserService();
        System.out.println(service.insertUser());
    }

}
