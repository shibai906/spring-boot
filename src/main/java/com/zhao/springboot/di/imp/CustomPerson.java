package com.zhao.springboot.di.imp;

import com.zhao.springboot.di.inter.Animal;
import com.zhao.springboot.di.inter.Persion;
import org.springframework.stereotype.Component;

@Component
public class CustomPerson implements Persion {
    @Override
    public void service() {

    }

    @Override
    public void setAnimal(Animal animal) {

    }
}
