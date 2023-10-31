package rafraf70.sandbox.pizza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PizzaApp

fun main(args: Array<String>) {
    runApplication<rafraf70.sandbox.pizza.PizzaApp>(*args)
}
