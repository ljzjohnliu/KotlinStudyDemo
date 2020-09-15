package com.ljz.kotlin.test

/**
 * 如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
 *
 * 伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
 */
fun User.Companion.foo() {
    println("伴随对象的扩展函数")
}

var User.Companion.no: Int
    get() = 10
    set(value) {}

/**扩展函数**/
fun User.Print() {
    println("用户名 $name")
}

fun User.foo() {
    println("扩展函数")
}

fun User.test() {
    println("I am just a test")
}

class User(var name: String) {

    companion object {} // 将被称为 "Companion"

    fun foo() {
        println("成员函数")
    }
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

open class CC

class DD : CC()

fun CC.foo() = "cc"

fun DD.foo() = "dd"

fun printFoo(c: CC) {
    println(c.foo())
}

fun Any?.toString(): String {
    if (this == null) return "null"
    /**
     * 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
     * 解析为 Any 类的成员函数
     */
    return toString()
}

/**
 * 扩展属性
 * 除了函数，Kotlin 也支持属性对属性进行扩展:
 * 扩展属性只能被声明为 val。
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1

/**
 * 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
 */
//val User.bar = 1 // 错误：扩展属性不能有初始化器

fun main(arg: Array<String>) {
    var user = User("Runoob")
    user.Print()

    /**
     * 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
     */
    user.foo()

    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值
    println(list.toString())

    /**
     * 扩展函数是静态解析的
     * 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
     * 如下实例执行输出结果为：cc
     */
    printFoo(DD())

    var t = null
    println(t.toString())
    println(t.toString().equals("null"))

    /**
     * 伴生对象的扩展函数优先于成员函数执行
     */
    println("no:${User.no}")
    User.foo()
}