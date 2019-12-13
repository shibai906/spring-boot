package com.zhao.springboot.exception;

import com.zhao.springboot.enums.ResultCode;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-13 00:00
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResult {

    /**
     * 异常状态码
     */
    private int code;

    /**
     * 用户看得见的异常，例如 用户名重复！！,
     */
    private String message;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常堆栈信息
     */
    //private String errors;

    /**
     * 对异常提示语进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e, String message) {
        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMessage(message);
        return result;
    }

    /**
     * 对异常枚举进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e) {

        ErrorResult result = new ErrorResult();
        result.setMessage(resultCode.message());
        result.setCode(resultCode.code());
        result.setException(e.getClass().getName());
        //result.setErrors(Throwables.getStackTraceAsString(e));
        return result;
    }

}
