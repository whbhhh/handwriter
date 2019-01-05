package com.whb.consumer;

import com.whb.framework.ProxyFactory;
import com.whb.provider.api.HelloService;

public class MyConsumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("1111");
        System.out.println(result);
    }
}
