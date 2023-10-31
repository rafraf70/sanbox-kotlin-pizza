package rafraf70.sandbox.pizza.common

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MessagesTest {

    @Test
    fun resolve() {

        val msg = rafraf70.sandbox.pizza.common.Messages.resolve( "ERROR_CUSTOMER_WITH_ID_EXISTS" , "11")
        println(msg)

    }
}
