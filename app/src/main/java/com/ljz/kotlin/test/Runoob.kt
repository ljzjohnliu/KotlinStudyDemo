package com.ljz.kotlin.test

/**
 * 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
 * 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
 * 注意：主构造器的参数可以在初始化代码段中使用，也可以在类主体定义的属性初始化代码中使用。 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）：
 * 如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
 */
class Runoob constructor(var name: String) {

    constructor(name: String, lastName: String) : this(name) {
        xing = "1111"
    }

//    var name = name
    //非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
    var xing:String = "li"

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    //Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,备用字段使用field关键字声明,field 关键词只能用于属性的访问器
    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set

    //优先执行init初始化块中的语句 再执行构造函数中的语句
    init {
        xing = "2222"
        println("Init $name, $lastName, $xing")
        xing = "3333"
    }

    fun foo() {
        println("Foo $name, $lastName, $xing, $no, $heiht")
    }
}

fun main(args: Array<String>) {
    var runoob = Runoob("ljz", "liu")
    runoob.lastName = "sun"
    runoob.no = 100
    runoob.foo()
}