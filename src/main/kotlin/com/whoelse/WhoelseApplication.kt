package com.whoelse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhoelseApplication

fun main(args: Array<String>) {
	// -Dspring.profiles.active=local
	runApplication<WhoelseApplication>(*args)
}
