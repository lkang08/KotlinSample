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

        println("#######function begin #######")
        function()
        hof()
        println("#######function end#######")


        println("#######NPE begin #######")
        npe()
        println("#######NPE end#######")
        // lambda

        collectionMethod()
    }
}

//function begin
fun function() {
    sum(1)
    sum(1, 2)

    var str = "abc"
    reformat(str)
    reformat(str, wordSeparator = '_') //默认参数，命名参数

    double(100)
}

fun sum(x: Int, y: Int = 0, z: Int = 0): Int {
    return x + y + z
}

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
}

fun double(x: Int): Int = 2 * x

fun hof() {
    //origin
    var input = listOf(1, 2, 3)
    var sum = 0
    for (i in input) sum += i
    sum.log("sum")

    //hof
    input = listOf(1, 2, 3)
    input.fold(0) { a, b -> a + b }.log("fold")

    //origin
    var input2 = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )
    sum = 0
    for (list in input2) {
        var sub = 1
        for (i in list) {
            sub *= i
        }
        sum += sub
    }
    sum.log("origin sum")

    //hof
    input2.map { it.fold(1) { a, b -> a * b } }
        .fold(0) { a, b -> a + b }
        .log("hof sum")
}

//function end

//Null safety
fun npe() {
    var a: String = "abc"
    // a = null
    var aLength = a.length

    var b: String? = "abc"
    b = null
    var bLength = b?.length


    //pic1 条件检查
    bLength = if (b != null) b.length else -1

    //2 安全调用
    bLength = b?.length
    var user: User? = User(name = "zhangsan", department = Department(head = User("leader", age = 30)))
    println(user?.department?.head?.name)

    //3 elvis
    bLength = b?.length ?: -1

    //4 !!操作符
    b = "bbb"
    bLength = b!!.length

    //5 安全的类型转换
    var bLength2: Int? = b as? Int

    println("aLength = $aLength bLength = $bLength")
}

//Smart casts
fun smartCasts(bill: Bill) {
    if (bill is WaterBill) {
        bill.water()
    }
    if (bill is ElectricityBill) {
        bill.electricity()
    }
}

//Lambda
fun lambdaMethod(list: List<String>) {
    var lambda = { a: Int, b: Int ->
        println("in lambda a = $a b = $b")
        a + b
    }
    lambda(100, 1)
    lambda.invoke(100, 1)

    list.forEach {
        print(it)
    }
    list.forEach({ element ->
        println(element)
    })

    list.forEach { element ->
        println(element)
    }

    list.forEach(::testLambdaFunction)
}

fun testLambdaFunction(string: String) {}

fun collectionMethod() {
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

public interface Bill {
    fun getCount(): Int
}

public class WaterBill : Bill {
    fun water() {
    }

    override fun getCount(): Int {
        return 0
    }
}

class ElectricityBill : Bill {
    fun electricity() {
    }

    override fun getCount(): Int {
        return 1
    }
}