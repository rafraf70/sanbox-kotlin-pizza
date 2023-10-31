package de.freischlag.sandbox.pizza.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByPhoneNumber( phoneNumber : String ) : Customer?

}
