package com.whb.provider.impl;

import com.whb.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String value) {
        return value;
    }
}
