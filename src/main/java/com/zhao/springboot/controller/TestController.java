package com.zhao.springboot.controller;

import com.zhao.springboot.di.imp.AllPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
public class TestController {

//    @Autowired
    AllPerson allPerson;

    @RequestMapping(value = { "/api/v1/test" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public String home() {
        allPerson.service();
        return "index";
    }

}
