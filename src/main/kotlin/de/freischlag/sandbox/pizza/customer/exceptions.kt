package de.freischlag.sandbox.pizza.customer

import de.freischlag.sandbox.pizza.common.ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER
import de.freischlag.sandbox.pizza.common.ERROR_CUSTOMER_WITH_ID_EXISTS
import de.freischlag.sandbox.pizza.common.Messages


class CustomerNotFoundException private constructor(message: String) : Exception(message) {
    companion object {
        fun throwPhoneNumberUnknown(phoneNumber: String): Nothing =
            throw CustomerNotFoundException(
                de.freischlag.sandbox.pizza.common.ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER(
                    phoneNumber
                )
            )
    }
}
class CustomerExistsException private constructor(message : String) : Exception(message) {
    companion object {
        fun throwForCustomerId(customerId : Long) : Nothing = throw CustomerExistsException(
            de.freischlag.sandbox.pizza.common.ERROR_CUSTOMER_WITH_ID_EXISTS(
                customerId
            )
        )
    }
}
