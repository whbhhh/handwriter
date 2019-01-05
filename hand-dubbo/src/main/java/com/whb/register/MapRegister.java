package com.whb.register;

import com.whb.framework.URL;

import java.util.HashMap;
import java.util.Map;

public class MapRegister {
    private static Map<String, Map<URL, Class>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url, Class implClass) {
        Map<URL, Class> map = new HashMap<>();
        map.put(url, implClass);
        REGISTER.put(interfaceName, map);
    }

    public static Class getClass(String interfaceName, URL url) {
        return REGISTER.get(interfaceName).get(url);
    }

    public static URL random(String interfaceName){
        return REGISTER.get(interfaceName).keySet().iterator().next();
    }
}
