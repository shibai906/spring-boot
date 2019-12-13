package com.zhao.springboot.exception;

import com.zhao.springboot.enums.ResultCode;
import lombok.Data;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-13 00:28
 **/
@Data
public class BusinessException extends RuntimeException {

    protected Integer code;

    protected String message;


    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

}
