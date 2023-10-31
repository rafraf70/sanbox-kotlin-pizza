package de.freischlag.sandbox.pizza.customer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import kotlin.test.assertNotNull

@DataJpaTest
@Import(CustomerTestContextConfiguration::class)
class CustomerServiceTest {

    @Autowired
    private lateinit var customerService: CustomerService

    @Test
    fun getCustomer() {
        // when
        val customer: Customer? = customerService.getCustomerByPhoneNumber("+49 123 456789")

        // then
        assertNotNull(customer) // using this provides smart-cast (assertj does not)
        assertThat(customer.fullName).isEqualTo("Enrico Pallazzo")
    }
}
