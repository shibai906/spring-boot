package com.zhao.springboot.exception;

import com.zhao.json.JSONResult;
import com.zhao.springboot.enums.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-13 00:16
 **/

@RestController
@RequestMapping("error")
public class TestErrorController {

    @RequestMapping(value = { "runtimeException" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object runtimeException() throws InterruptedException, ExecutionException {
        int i = 1/0;
        return JSONResult.success();
    }


    @RequestMapping(value = { "exception" }, method = { RequestMethod.POST, RequestMethod.GET }, produces="application/json;charset=UTF-8")
    public Object exception() throws Exception {
        throw new Exception("哈哈哈");
    }

    @RequestMapping(value="/businessException")
    public void  businessException(  ){
        throw new BusinessException(ResultCode.USER_HAS_EXISTED);
    }

}
