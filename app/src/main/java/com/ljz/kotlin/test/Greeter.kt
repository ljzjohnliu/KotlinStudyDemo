package com.ljz.kotlin.test

//面向对象
class Greeter(val name: String) {
    fun greet() {
        println("Hello, $name")
    }
}

fun main(args: Array<String>) {
    Greeter("World!").greet()
}