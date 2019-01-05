package com.whb.framework;

import com.whb.protocol.http.HttpClient;
import com.whb.provider.api.HelloService;
import com.whb.register.MapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(HelloService.class.getName(),
                        method.getName(),
                        args, method.getParameterTypes());
                URL url = MapRegister.random(interfaceClass.getName());
                String result = httpClient.post(url.getHostname(), url.getPort(), invocation);
                return result;
            }
        });
    }
}
