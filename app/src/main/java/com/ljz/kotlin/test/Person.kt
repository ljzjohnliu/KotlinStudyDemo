package com.ljz.kotlin.test

/**
 * 类的修饰符
类的修饰符包括 classModifier 和_accessModifier_:

classModifier: 类属性修饰符，标示类本身特性。

abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类


accessModifier: 访问权限修饰符

private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
 */

/**
 * 注意：在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。
 * 这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
 */
class Person constructor(var name: String = "new person") {

    fun hello() {
        println("My name is $name")
    }
}

/**
 * 在java中允许创建任意的子类并重写方法任意的方法，除非显示的使用了final关键字进行标注。
 * 而在kotlin的世界里面则不是这样，在kotlin中它所有的类默认都是final的，那么就意味着不能被继承，而且在类中所有的方法也是默认是final的，那么就是kotlin的方法默认也不能被重写。那么想在kotlin中继承父类应该怎么做呢？
 * 为类增加open，class就可以被继承了
 * 为方法增加open，那么方法就可以被重写了
 *
 * 注意：无需对抽象类或抽象成员标注open注解。
 */
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo(): Int {
            //报错 不能访问外部类的bar变量
//            println("I can not visit Outer bar is $bar")
            return 2
        }
    }

    inner class Nested2 {

        fun foo() = bar // 访问外部类成员

        fun innerTest() {
            //为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签
            var o = this@Outer //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.bar)
        }
    }
}

//匿名内部类
class Test {
    var v = "成员属性"

    fun setInterFace(testInterFace: TestInterFace) {
        testInterFace.test()
    }
}

/**
 * 定义接口
 */
interface TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var person = Person("ljz")
    person.hello()

    var nested = Outer.Nested().foo()
    println(nested)

    var nested2 = Outer().Nested2()
    println(nested2.foo())
    nested2.innerTest()

    var test = Test()
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }

    })
}