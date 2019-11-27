package com.zhao.springboot.di.imp;

import com.zhao.springboot.di.inter.HelloService;
import org.springframework.util.StringUtils;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(StringUtils.isEmpty(name)) {
            throw new RuntimeException("parameter is null!");
        }
        System.out.println(name);
    }
}
