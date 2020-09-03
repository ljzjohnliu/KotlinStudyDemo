package com.ljz.kotlin.test

fun main(args: Array<String>) {
    var a = 1
    var b = 2
    val c = if (a >= b) a else b
    println("c 的值为 $c")

    val xx = 5
    if (xx in 1..8) {
        println("xx 在区间内")
    }

    when (xx) {
        1 -> println("xx == 1")
        2 -> println("xx == 2")
        else -> { // 注意这个块
            println("xx 不是 1, 也不是 2")
        }
    }

    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val items2 = listOf("apple", "banana", "kiwi")
    for (item in items2) {
        println(item)
    }

    for (index in items2.indices) {
        println("item at $index is ${items2[index]}")
    }

//    println("----while 使用-----")
//    var x = 5
//    while (x > 0) {
//        println(x--)
//    }
//    println("----do...while 使用-----")
//    var y = 5
//    do {
//        println(y--)
//    } while (y > 0)


    /**
     * 在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可。
     * 标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
     */
//    loop@ for (i in 1..3) {
//        for (j in 1..3) {
//            if (i == 2 && j == 1) continue@loop
//            println("i = $i, j = $j")
//        }
//    }

//    foo()
//    foo1()
//    foo2()
    foo3()
}

var ints = arrayOf(1, 2, 0, 3, 4)

/**
 * 标签处返回
 * Kotlin 有函数字面量、局部函数和对象表达式。因此 Kotlin 的函数可以被嵌套。 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。回想一下我们这么写的时候：
 */
fun foo() {
    ints.forEach {
        if (it == 0) return
        print(it)
    }
}

/**
 *这个 return 表达式从最直接包围它的函数即 foo 中返回。 （注意，这种非局部的返回只支持传给内联函数的 lambda 表达式。） 如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return。
 */

fun foo1() {
    ints.forEach lit@{
        if (it == 0) return@lit
        print(it)
    }
}

/**
 * 现在，它只会从 lambda 表达式中返回。通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名。
 */
fun foo2() {
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }
}

/**
 * 或者，我们用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
 */
fun foo3() {
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        print(value)
    })
}