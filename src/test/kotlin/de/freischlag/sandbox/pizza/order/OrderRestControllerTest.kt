package de.freischlag.sandbox.pizza.order

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import pizza.customer.Customer
import pizza.customer.CustomerRepository
import pizza.customer.CustomerService
import pizza.order.OrderRestController
import pizza.product.Product
import pizza.product.ProductRepository
import pizza.product.ProductService
import java.util.*

@WebMvcTest(OrderRestController::class)
@Import(OrderService::class, CustomerService::class, ProductService::class)
@AutoConfigureDataJpa
internal class OrderRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @BeforeEach
    fun setupTestData() {
        productRepository.deleteAll()
        productRepository.save(Product("p1", "Product One", 1.00))
        customerRepository.deleteAll()
        customerRepository.save(Customer("Toni Test", null, "040-112233"))
    }

    @Test
    fun placeOrder() {
        // given
        val orderRequestData = OrderRequest(
            phoneNumber = "040-112233",
            itemQuantities = Collections.singletonMap("p1", 2)
        )

        // when
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post(OrderRestController.PLACE_ORDER_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(orderRequestData))
        )

        // then
        resultActions
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalPrice", Matchers.`is`(2.0)))
            .andExpect(
                MockMvcResultMatchers.jsonPath(
                    "$.customer.fullName",
                    Matchers.`is`("Toni Test")
                )
            )
    }

    private fun toJson(`object`: Any): String {
        return objectMapper.writeValueAsString(`object`)
    }
}
