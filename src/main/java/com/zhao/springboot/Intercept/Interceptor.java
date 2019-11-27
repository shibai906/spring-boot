package com.zhao.springboot.Intercept;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    // 方法执行前
    boolean before();

    // 方法执行后
    void after();

    /**
     * 取代原有方法
     * @param invocation --回调参数，可以通过它的proceed方法，回调原有时间
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    // 事后返回方法，事件没有发生异常
    void afterReturning();

    // 事后异常方法，当事件发生异常后执行
    void afterThrowing();

    // 是否使用around方法取代原先方法
    boolean userAround();

}
