package com.zhao.springboot.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-13 00:40
 **/
@ControllerAdvice(basePackages = "com.zhao.springboot")
public class ResponseHandler  implements ResponseBodyAdvice<Object> {
    /**
     * 是否支持advice功能
     * treu=支持，false=不支持
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     *
     * 处理response的具体业务方法
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) o;
            return Result.fail(errorResult.getCode(),errorResult.getMessage());
        } else if (o instanceof String) {
            return JsonUtil.object2Json(Result.suc(o));
        }
        return Result.suc(o);
    }
}
