package rafraf70.sandbox.pizza.customer

import rafraf70.sandbox.pizza.common.ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER
import rafraf70.sandbox.pizza.common.ERROR_CUSTOMER_WITH_ID_EXISTS
import rafraf70.sandbox.pizza.common.Messages


class CustomerNotFoundException private constructor(message: String) : Exception(message) {
    companion object {
        fun throwPhoneNumberUnknown(phoneNumber: String): Nothing =
            throw CustomerNotFoundException(
                rafraf70.sandbox.pizza.common.ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER(
                    phoneNumber
                )
            )
    }
}
class CustomerExistsException private constructor(message : String) : Exception(message) {
    companion object {
        fun throwForCustomerId(customerId : Long) : Nothing = throw CustomerExistsException(
            rafraf70.sandbox.pizza.common.ERROR_CUSTOMER_WITH_ID_EXISTS(
                customerId
            )
        )
    }
}
