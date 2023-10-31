package rafraf70.sandbox.pizza.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository : CustomerRepository
)
{

    /**
     * @throws CustomerExistsException
     */
    fun createCustomer(customer: Customer) {

        customer.id?.run {
            if (customerRepository.existsById(this)) {
                CustomerExistsException.throwForCustomerId(this)
            }
        };
        customerRepository.save(customer)
    }

    /**
     * Returns a [Customer] with a matching phone-number or throws [CustomerNotFoundException]
     * @throws CustomerNotFoundException
     */
    fun getCustomerByPhoneNumber(phoneNumber: String): Customer {
        return customerRepository.findByPhoneNumber(phoneNumber)
            ?: CustomerNotFoundException.throwPhoneNumberUnknown(phoneNumber)
    }

}
