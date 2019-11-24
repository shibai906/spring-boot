package com.zhao.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("haha")
public class TestHaHa {
    @Value("239023")
    private long id;
    @Value("palalala")
    private String pa;
}
