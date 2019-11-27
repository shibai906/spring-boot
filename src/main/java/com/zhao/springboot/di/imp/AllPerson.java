package com.zhao.springboot.di.imp;

import com.zhao.springboot.di.inter.Animal;
import com.zhao.springboot.di.inter.Persion;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class AllPerson implements Persion , BeanNameAware , BeanFactoryAware , ApplicationContextAware , InitializingBean , DisposableBean {

    public AllPerson(@Autowired Animal animal) {
        this.animal = animal;
    }

//    @Autowired
    Animal animal;

    public AllPerson() {
        System.out.println("我创建了");
    }


    @Override
    public void service() {
//        animal.use();
    }

    @Override
    public void setAnimal( Animal animal) {
        System.out.println("提前注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware的setBeanName");
        System.out.println("他的作用只是获取到bean的名字，一般一个类型的bean只有一个，这个方法在这里看起来就有一些鸡肋了");
        System.out.println(s);
        s = "动物";
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBean(AllPerson.class));
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware的setApplicationContext方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用InitalizingBean的afterPropertiesSet方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName() + "】注解@PostConstruet定义的自定义初始化方法");
    }

    @PreDestroy
    public void destory1() {
        System.out.println("【" + this.getClass().getSimpleName() + "】注解@PreDestory定义的自定义摧毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用DisposableBean方法");
    }

}
