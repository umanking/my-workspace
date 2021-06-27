package com.example.demo.chapter_02_tutorials

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithprefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int = x + y
fun multiply(x: Int, y: Int) = x * y
fun main() {
    printMessage("hello")
    printMessageWithprefix("hello", "log")
    printMessageWithprefix("hello")
    printMessageWithprefix(prefix = "LOGG", message = "hello")
    println(sum(1, 2))
    println(multiply(2, 4))


}