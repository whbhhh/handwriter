package com.whb.provider;

import com.whb.framework.URL;
import com.whb.protocol.http.HttpServer;
import com.whb.provider.api.HelloService;
import com.whb.provider.impl.HelloServiceImpl;
import com.whb.register.MapRegister;

public class MyProvider {

    public static void main(String[] args) {
        URL url = new URL("localhost", 8080);
        MapRegister.register(HelloService.class.getName(), url, HelloServiceImpl.class);
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
    }
}
