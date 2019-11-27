package com.zhao.springboot.di.imp;

import com.zhao.springboot.di.inter.Animal;
import com.zhao.springboot.di.inter.Persion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class BussinessPerson implements Persion {

/*    @Autowired
    @Qualifier("dog")
    private Animal animal ;*/

    private Animal animal ;
    public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

    @Override
    public void service() {
        animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
