package com.example.kotlin;

public class JavaTest {
    public static void main(String[] args) {
        KotlinTest.test();
        KotlinTest.INSTANCE.method();
        System.out.println("jvmStr = " + KotlinTest.jvmStr + " , normalStr = " + KotlinTest.INSTANCE.getNormalStr());
    }

    void oldMethod() {
        System.out.println("JavaTest.oldMethod : " + this);
    }

}
