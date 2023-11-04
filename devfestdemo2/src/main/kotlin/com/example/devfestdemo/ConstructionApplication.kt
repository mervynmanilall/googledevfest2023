package com.example.devfestdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConstructionApplication

fun main(args: Array<String>) {
	runApplication<ConstructionApplication>(*args)
}
