package com.ljz.kotlin.test

class Box<T>(t: T) {
    var value = t

    fun <T> boxIn(value: T) = Box(value)

}

fun main(args: Array<String>) {
    val boxInt: Box<Int> = Box<Int>(1)
    val boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)

    val age = 20
    val name = "ljz"
    val bool = false

    doPrint(age)
    doPrint(name)
    doPrint(bool)
}

fun <T> doPrint(content: T) {
    when(content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}