package com.whb;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
   public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
   static {
       servletMappingList.add(new ServletMapping("helloServlet","/hello","com.whb.HelloServlet"));
   }

}
