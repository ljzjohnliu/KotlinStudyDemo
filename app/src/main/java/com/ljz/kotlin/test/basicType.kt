package com.ljz.kotlin.test

fun main(args: Array<String>) {
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等

    /**
     *类型转换
     *  由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
     */
    val b: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = b // 错误
    val i: Int = b.toInt() // OK

    /**
     * 位操作符
    对于Int和Long类型，还有一系列的位操作符可以使用，分别是：

    shl(bits) – 左移位 (Java’s <<)
    shr(bits) – 右移位 (Java’s >>)
    ushr(bits) – 无符号右移位 (Java’s >>>)
    and(bits) – 与
    or(bits) – 或
    xor(bits) – 异或
    inv() – 反向
     */

    //[1,2,3]
    val Aa = arrayOf(1, 2, 3)
    //[0,2,4]
    val Ab = Array(4, { i -> (i * 2) })

    //读取数组内容
    println(Aa[0])    // 输出结果：1
    println(Ab[3])    // 输出结果：2

    val text = """
    多行字符串
    多行字符串
    """
    println(text)   // 输出有一些前置空格

    val text2 = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin() //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    println(text2)    // 前置空格删除了

//    val price = """
//    ${'$'}9.99
//    """
    val price = """
    $9.99
    """
    println(price)  // 求值结果为 $9.99
}