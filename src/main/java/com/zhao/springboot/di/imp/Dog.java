package com.zhao.springboot.di.imp;


import com.zhao.springboot.di.inter.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component
public class Dog implements Animal {

    @Autowired
    AllPerson allPerson;

    public Dog() {
        System.out.println("我是狗，我创建了");
    }

    @Override
    public void use() {
        System.out.println("狗[" + Dog.class.getSimpleName() + "]是用来看门的");
    }
}
