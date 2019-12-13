package com.zhao.springboot.aysnc.controller;

import com.zhao.json.JSONResult;
import com.zhao.springboot.aysnc.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("ansyc")
public class AnsycController {

    @Autowired
    ScoreService service;

    @RequestMapping(value = { "testAnsyc1" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertInfo1() throws InterruptedException, ExecutionException {

        for(int i = 0 ; i < 20 ; i ++) {
            service.sendRedPacket();
            service.sendSoce();
        }

        return JSONResult.success();
    }

    @RequestMapping(value = { "testAnsyc2" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertInfo2() throws InterruptedException {

        service.sendSoce();
        return JSONResult.success();
    }


}
