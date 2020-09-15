package com.ljz.kotlin.test

import com.ljz.kotlin.test.test
import com.ljz.kotlin.test.User

fun main(args: Array<String>) {
    val c = InterfaceTest()
    c.bar()
    c.foo()
    c.Print()
}

/**扩展函数**/
fun InterfaceTest.Print(){
    print("用户名 $name")
}

class InterfaceTest : MyInterFace {
    override var name: String = "ljz"

    override fun bar() {
        println("bar")
    }
}

interface MyInterFace {
    var name: String
    fun bar()
    fun foo() {
        println("Hello, foo! My name is $name")
    }
}
