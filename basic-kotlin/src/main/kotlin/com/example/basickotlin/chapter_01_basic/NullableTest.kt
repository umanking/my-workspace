package com.example.demo

fun main() {
    println(printProduct("1", "3"))
    println(printProduct("a", "3"))
}

fun parseInt(str: String): Int?{
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x == null) {
        println("wrong number: $arg1")
        return
    }

    if (y == null) {
        println("wrong number: $arg2")
        return
    }

    println(x * y)
}