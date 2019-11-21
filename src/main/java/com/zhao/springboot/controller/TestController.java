package com.zhao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {



    @RequestMapping(value = { "/api/v1/test" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public String home() {
        return "index";
    }

}
