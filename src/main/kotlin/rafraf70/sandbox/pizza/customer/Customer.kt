package rafraf70.sandbox.pizza.customer

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.core.annotation.Order


@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        set(value) {
            check(field == null) { "Cannot change existing id" }
            field = value
        }

    var fullName: String

    @Embedded
    var address: Address?

    var phoneNumber: String?

    var orderCount: Int = 0


    //
    // --- constructors ---
    //

    constructor() : this("", null, null)

    constructor(fullName: String, address: Address?, phoneNumber: String?) {
        this.id = null
        this.fullName = fullName
        this.address = address
        this.phoneNumber = phoneNumber
    }

    //
    // --- other methods ---
    //

    fun increaseOrderCount(): Int {
        return orderCount++
    }

    override fun toString(): String {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderCount=" + orderCount +
                '}'
    }
}
