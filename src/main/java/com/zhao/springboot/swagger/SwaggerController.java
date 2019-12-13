package com.zhao.springboot.swagger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "swagger测试接口")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {


    @ApiOperation("修改某条数据")
    @RequestMapping(value = { "select/{id}" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object
    select(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        user.setUsername("username");
        user.setPassword("password");
        return JSON.toJSON(user);
    }

    @ApiOperation("插入某条数据")
    @RequestMapping(value = { "insert" }, method = { RequestMethod.POST,RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object insert(@RequestBody User user) {
        return user;
    }

}
