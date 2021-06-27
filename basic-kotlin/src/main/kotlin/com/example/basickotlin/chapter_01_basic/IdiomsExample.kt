package com.example.demo.chapter_01_basic

import java.math.BigDecimal

fun main() {
//    read-only list, map ...
    val list = listOf("a", "b", "c")
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map["a"])

    for ((k, v) in map) {
        println("$k -> $v")

    }

    "Convert this to".spaceToCalmelCase()

    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

        override fun sleep() {
            TODO("Not yet implemented")
        }

    }

    println(transform("green"))

    println(foo(1))

    calcTaxes()
}

fun String.spaceToCalmelCase() {

}

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()

}

fun transform(color: String): Int {
    return when (color) {
        "red" -> 0
        "green" -> 1
        "blue" -> 2
        else -> throw IllegalArgumentException("invalid arguemnt")

    }
}

fun foo(param: Int): String {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
    return result
}

fun calcTaxes(): BigDecimal = TODO("NOT IMPLEMNTED")
