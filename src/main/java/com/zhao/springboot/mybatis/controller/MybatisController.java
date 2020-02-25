package com.zhao.springboot.mybatis.controller;

import com.zhao.json.JSONResult;
//import com.zhao.springboot.mybatis.domain.Caonima;
//import com.zhao.springboot.mybatis.mapper.CaonimaDAO;
//import org.springframework.beans.factory.annotation.Autowired;
import com.zhao.springboot.mybatis.account.domain.Caonima;
import com.zhao.springboot.mybatis.account.mapper.CaonimaDAO;
import com.zhao.springboot.mybatis.redaccount.domain.School;
import com.zhao.springboot.mybatis.redaccount.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-17 22:47
 **/
@RestController
@RequestMapping("mybatis")
public class MybatisController {

    @Autowired
    CaonimaDAO caonimaDAO;

    @Autowired
    SchoolMapper schoolMapper;

    @RequestMapping(value = { "insertSchool" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insertSchool() throws InterruptedException, ExecutionException {
        School school = new School();
        school.setAge(23);
        school.setLevel("层级");
        school.setName("name");
        schoolMapper.insert(school);
        return JSONResult.success();
    }

    @RequestMapping(value = { "insert" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insert() throws InterruptedException, ExecutionException {
        Caonima user = new Caonima();
        user.setUsername("username");
        user.setPassword("password");
        caonimaDAO.insert(user);
        return JSONResult.success();
    }

    @RequestMapping(value = { "get/{id}" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object get(@PathVariable long id) throws InterruptedException, ExecutionException {
//        System.out.println(caonimaDAO);
        return JSONResult.success();
    }



}
