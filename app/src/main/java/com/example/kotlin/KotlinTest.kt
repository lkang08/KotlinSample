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

    fun testMethod() {
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
        println("#######NPE begin #######")
        npe()
        println("#######NPE end#######")
        // lambda

        function()

        println("##############")
        var r = test(10) { num1: Int, num2: Int ->
            var temp = 100
            println("in lambda $temp")
            num1 * num2 + num1
        }
        println("result = $r")
        /*println("fibnoacci2()调用：")
        for (i in fibnoacci2()) {
            if (i > 100) break
            println(i)
        }*/
    }
}

fun npe() {
    var a: String = "abc"
    // a = null
    var aLength = a.length

    var b: String? = "abc"
    b = null
    var bLength = b?.length


    //1 条件检查
    bLength = if (b != null) b.length else -1

    //2 安全调用
    bLength = b?.length
    var user: User? = User(name = "zhangsan", department = Department(head = User("leader", age = 30)))
    println(user?.department?.head?.name)

    //3 elvis
    bLength = b?.length ?: -1

    //4 !!操作符
    bLength = b!!.length

    //5 安全的类型转换
    var bLength2: Int? = b as? Int

    println("aLength = $aLength bLength = $bLength")
}


fun function() {
    var person = arrayListOf(User(name = "zhangsan"),
            User(name = "lisi", age = 20),
            User(name = "wangwu", age = 30),
            User(name = "lily", age = 18))
    println(person.filter { it.age > 10 })
    println(person.map { it.name })
    println(person.all { it.age > 18 })
    println(person.any { it.age < 18 })
    println(person.count { it.age >= 18 })
    println(person.maxBy { it.age })
    println(person.groupBy { it.name.length })
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

data class User(var name: String = "", var sex: String = "0", var age: Int = 10, var department: Department? = null)

data class Department(var head: User? = null)