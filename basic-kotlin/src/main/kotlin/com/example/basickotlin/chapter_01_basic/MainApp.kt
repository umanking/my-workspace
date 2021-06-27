package com.example.demo

fun main() {

    for (i in 1..10 step 2) {
        print(i)
    }

    println()

    for (i in 9 downTo 0 step 3) {
        print(i)
    }

    println()


    val fruits = listOf("banna", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

//Unit은 Java에서 void를 의미함
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun loop() {
    val items = listOf("apple", "banna", "kiwi")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "one"
        "hello" -> "world"
        is Long -> "long"
        else -> "unknown"
    }

fun rangeTest() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("first in range")

    }
}
