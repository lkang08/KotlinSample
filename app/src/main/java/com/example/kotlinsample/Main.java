package com.example.kotlinsample;

public class Main {
    public static void main(String[] args) {
        KotlinTest.test();
        KotlinTest.INSTANCE.method();
        System.out.println("jvmStr = " + KotlinTest.jvmStr + " , norStr = " + KotlinTest.INSTANCE.getNorStr());
    }
}
