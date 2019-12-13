package com.zhao.springboot.exception;

import com.zhao.springboot.enums.ResultCode;
import com.zhao.springboot.exception.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-13 00:02
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    private
    /**
     * 处理运行时异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        //TODO 运行是异常，可以在这里记录，用于发异常邮件通知
        ErrorResult error = ErrorResult.fail(ResultCode.SYSTEM_ERROR, e);
        log.error("URL:{} ,系统异常: ",request.getRequestURI(), e);
        return error;
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleBusinessException(BusinessException e, HttpServletRequest request) {
        ErrorResult error = new ErrorResult();
        error.setCode(e.code);
        error.setMessage(e.getMessage());
        error.setException(e.getClass().getName());
        log.warn("URL:{} ,业务异常:{}", request.getRequestURI(),error);
        return error;
    }

}
