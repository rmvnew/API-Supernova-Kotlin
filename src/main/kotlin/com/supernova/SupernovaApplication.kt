package com.supernova

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SupernovaApplication

fun main(args: Array<String>) {
	runApplication<SupernovaApplication>(*args)
}
