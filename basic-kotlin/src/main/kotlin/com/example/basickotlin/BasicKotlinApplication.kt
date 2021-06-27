package com.example.basickotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicKotlinApplication

fun main(args: Array<String>) {
	runApplication<BasicKotlinApplication>(*args)
}
