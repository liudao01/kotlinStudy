package com.ktdemo.lib.java.s02;

import com.ktdemo.lib.kt.s02.KTStudentKt;

public class Client {


    void test() {
        KTStudentKt.show("derry1");

        KTStudentKt.show2("Derry2");

        KTStudentKt.add(100, 100);

        // Java　无法 调用
        /*`showTest`();
        `4325436465375`("Derry");
        `   `('M');*/
    }

}
