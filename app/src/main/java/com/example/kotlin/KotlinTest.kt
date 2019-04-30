package com.example.kotlin

object KotlinTest {
    @JvmField
    var jvmStr = "str1"

    var normalStr: String? = null

    @JvmStatic
    fun test() {
        println("kotlin test println normalStr = $normalStr")
        normalStr = "hello kotlin"
    }

    fun method() {
        println("kotlin method println normalStr = $normalStr")
    }

    var user: User? = null
    @JvmStatic
    fun main(args: Array<String>) {
        var s = "abcd"
        s.print()
        s.format()
        user = User("Kotlin", "man")
        var result = user?.let {
            println("user name = ${this}")
            println("user name = ${it.name}")
            User("Kotlin 2", "girl")
        }
        println("after let user name = ${result?.name}")
    }
}

fun String.print() {
    println("String.print : $this")
}

fun String.format(): String {
    return "format String : $this"
}

data class User(var name: String = "", var sex: String = "0")