package com.ljz.kotlin.test

class D {
    fun bar() {
        println("D bar")
    }
}

class C {
    fun baz() {
        println("C baz")
    }

    // 与 D 类 的 bar 同名
    fun bar() {
        println("C bar")
    }

    /**
     * 在一个类内部你可以为另一个类声明扩展。
     * 在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
     * 在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
     * 假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
     */
    fun D.foo() {
        bar()   // 调用 D.bar()，扩展接收者优先
        this@C.bar() // 调用 C.bar()
        baz()   // 调用 C.baz
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

fun main(args: Array<String>) {
    val c: C = C()
    val d: D = D()
    c.caller(d)
}