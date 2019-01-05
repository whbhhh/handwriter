package com.whb;

import java.io.IOException;

public class HelloServlet extends MyServlet {
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("hello world ---> GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("hello world ---> POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
