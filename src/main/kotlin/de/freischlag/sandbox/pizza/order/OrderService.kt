package de.freischlag.sandbox.pizza.order

import org.springframework.stereotype.Service

@Service
class OrderService {

    fun placeOrder(phoneNumber: String, itemQuantities: Map<String, Int>): Order {
        // load customer
        // todo

        // ask product-service for total price
        // todo

        // create order
        // todo

        // persist and return it
        // todo
        return Order()
    }


    fun getOrders(): List<Order> {
        // todo
        return listOf()
    }

}
