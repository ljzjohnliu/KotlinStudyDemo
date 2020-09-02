package com.ljz.kotlin.test

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

public fun sum3(a: Int, b: Int) = a + b

//可变长参数函数
fun vars(vararg v: Int) {
    for (vt in v) {
        print(vt)
    }
}

//lambda匿名函数
val sumLambda: (Int, Int) -> Int = { x, y -> x + y }

//类型检测及自动类型转换  我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

    //在这里还有一种方法，与Java中instanceof不同，使用!is
    // if (obj !is String){
    //   // XXX
    // }

    // 这里的obj仍然是Any类型的引用
    return null
}

fun main(args: Array<String>) {
    var result = sum(1, 2)
    var result2 = sum2(2, 3)
    var result3 = sum3(3, 3)
//    println("1 + 2 = $result")
//    println("2 + 3 = $result2")
//    println("3 + 3 = $result3")
//    vars(1, 2, 3, 4, 5)
//    println(sumLambda(1, 2))

    //定义不可变变量
    val a: Int = 1
    val b = 1       // 系统自动推断变量类型为Int
    val c: Int      // 如果不在声明时初始化则必须提供变量类型
    c = 1           // 明确赋值

    //定义可变变量
    var x = 5        // 系统自动推断变量类型为Int
    x += 1           // 变量可修改

    var s1 = "x is $x"
    x = 2

    val s2 = "${s1.replace("is", "was")}, but now is $x"
    println("$s2")


    //NULL检查机制
    //类型后面加?表示可为空
    var age: String? = null
    //抛出空指针异常
//    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    println("ages1 is $ages1")
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println("ages2 is $ages2")

    var length = getStringLength(s2)
    println("$length")

    /**
     * 区间
     * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
     * 区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例:
     */
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}