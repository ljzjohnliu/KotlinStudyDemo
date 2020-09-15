package com.ljz.kotlin.test

/**
Kotlin 数据类与密封类
 */
data class DataTest(val name: String, val age: Int)


fun main(args: Array<String>) {
    val ljz = DataTest("ljz", 30)
    val jack = DataTest(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(ljz)
    println(jack)
    println(olderJack)

    /**
     * 组件函数允许数据类在解构声明中使用：
     */
    val jane = DataTest("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // prints "Jane, 35 years of age"
}