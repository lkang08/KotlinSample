package com.example.kotlin;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class JavaTest {
    public static void main(String[] args) {
        KotlinTest.test();
        KotlinTest.INSTANCE.method();
        System.out.println("jvmStr = " + KotlinTest.jvmStr + " , normalStr = " + KotlinTest.INSTANCE.getNormalStr());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(View view) {
            super(view);
        }
    }
}
