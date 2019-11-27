package com.zhao.springboot.di.imp;

import com.zhao.springboot.di.inter.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class Cat implements Animal {

    @Autowired
    AllPerson person;

    public Cat(@Autowired AllPerson person){
        System.out.println("我是猫，我创建了");
    }

    @Override
    public void use() {

        System.out.println("猫【" + Cat.class.getSimpleName() + "】是用来宠的");

    }
}
