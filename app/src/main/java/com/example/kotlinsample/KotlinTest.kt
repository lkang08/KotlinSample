package com.example.kotlinsample

object KotlinTest {
    @JvmField
    var jvmStr = "str1"

    var norStr: String? = null
    @JvmStatic
    fun test() {
        println("kotlin test println norStr = $norStr")
        norStr = "hello kotlin"
    }

    fun method() {
        println("kotlin method println norStr = $norStr")
    }
}