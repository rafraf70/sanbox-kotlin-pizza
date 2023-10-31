package de.freischlag.sandbox.pizza.order

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class OrderRestController(
    private val orderService: OrderService
) {

    @PostMapping(PLACE_ORDER_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    fun placeOrder(@RequestBody orderRequest: OrderRequest): Order {
        return orderService.placeOrder(
            orderRequest.phoneNumber,
            orderRequest.itemQuantities
        )
    }


    @GetMapping(GET_MANY_ENDPOINT)
    fun allOrders() =
        orderService.getOrders()


    companion object {
        const val ROOT = "/orders"
        const val PLACE_ORDER_ENDPOINT = ROOT
        const val GET_MANY_ENDPOINT = ROOT
    }
}
