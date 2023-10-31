package de.freischlag.sandbox.pizza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PizzaApp

fun main(args: Array<String>) {
    runApplication<de.freischlag.sandbox.pizza.PizzaApp>(*args)
}
