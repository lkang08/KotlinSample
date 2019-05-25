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
        println("kotlin oldMethod println normalStr = $normalStr")
    }

    var user: User? = null
    @JvmStatic
    fun main(args: Array<String>) {
        user = User("Kotlin", "man")
        var result = user?.let {
            println("user name = ${this}")
            println("user name = ${it.name}")
            User("Kotlin 2", "girl")
        }
        println("after let user name = ${result?.name}")
        println("##############")
        // lambda


        var r = test(10) { num1: Int, num2: Int ->
            var temp = 100
            println("in lambda $temp")
            num1 * num2 + num1
        }
        println("result = $r")
        println("fibnoacci2()调用：")
        for (i in fibnoacci2()) {
            if (i > 100) break
            println(i)
        }
    }
}

fun fibnoacci2(): Iterable<Long> { //返回值为一个迭代器
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() { //匿名对象
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

            override fun hasNext(): Boolean = true
        }
    }
}

fun test(a: Int, b: (num1: Int, num2: Int) -> Int): Int {
    return a + b.invoke(3, 5)
}

data class User(var name: String = "", var sex: String = "0")