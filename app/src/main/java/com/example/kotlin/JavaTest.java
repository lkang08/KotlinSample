package com.example.kotlin;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {
    public static void testFunction(List<Integer> integerList) {
        int sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    public static void testFunction2(List list) {
        // todo
    }

    public static void main(String[] args) {
        List rawList = new ArrayList();
        rawList.add("data1");
        rawList.add(2);

    }

}