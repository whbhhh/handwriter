package com.whb.protocol.http;

import com.whb.framework.Invocation;
import com.whb.framework.URL;
import com.whb.register.MapRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    /**
     * 处理请求
     *
     * @param req
     * @param resp
     */
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            URL url = new URL("localhost", 8080);
            Class implClass = MapRegister.getClass(invocation.getInterfaceName(), url);
            Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(result, resp.getOutputStream());
        } catch (Exception e) {
        }
    }
}
