package com.ljz.kotlin.test

open class Worker(var name: String) {
    // 基类
    var age: Int = 0

    constructor(name: String, age: Int) : this(name) {
        this.age = age
        //初始化
        println("-------基类次级构造函数---------")
    }

    open fun dowork() {       // 允许子类重写
        println("我在工作！")
    }
}

//class Student(name: String, age: Int, var no: String, var score: Int) : Worker(name, age) {
class Student : Worker {
    constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {
        println("---Student----继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

class Doctor : Worker {
    constructor(name: String) : super(name, 0) {
        println("----Doctor---继承类次级构造函数---------")
    }

    override fun dowork() {    // 重写方法
        println("我在给病人看病!")
    }
}

// 测试
fun main(args: Array<String>) {
    val s = Student("Runoob", 18, "S12346", 89)
    val doctor = Doctor("ljz")
    doctor.dowork()
}