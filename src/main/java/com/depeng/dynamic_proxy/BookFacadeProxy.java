package com.depeng.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);  //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷) 
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy 开始调用");
        Object invoke = method.invoke(target, args);
        System.out.println("Proxy 完成调用");
        return invoke;
    }
}
