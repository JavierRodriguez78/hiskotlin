package com.javierrodriguez.hiskotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HiskotlinApplication

fun main(args: Array<String>) {
    runApplication<HiskotlinApplication>(*args)
}
