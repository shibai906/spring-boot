package com.zhao.springboot;

import com.zhao.springboot.Intercept.Interceptor;
import com.zhao.springboot.Intercept.Invocation;
import com.zhao.springboot.Intercept.MyIntercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target , Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        // 保存代理对象
        proxyBean.target = target ;
        // 保存拦截器
        proxyBean.interceptor = interceptor;

        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces(),proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Invocation invocation = new Invocation(target,method,args);
        Object object = null ;
        interceptor.before();
       try {
           if(interceptor.userAround()) {
               interceptor.around(invocation);
           } else {
               invocation.proceed();
           }
            interceptor.afterThrowing();
       } catch (Exception e) {
           interceptor.afterReturning();
       }
       interceptor.after();
       return object;
    }
}
