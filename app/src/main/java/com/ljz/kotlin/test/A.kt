package com.ljz.kotlin.test

open class A {
    open val x: Int = 1

    open fun f() {
        println("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        println("B")
    }

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    //你可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
    override var x: Int = 2

    override fun f() {
        super<A>.f()
        super<B>.f()
        println("x is $x")
    }
}

//你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
class A1(override val x: Int = 2) : A() {

}

fun main(args: Array<String>) {
    val c = C()
    c.f()
}