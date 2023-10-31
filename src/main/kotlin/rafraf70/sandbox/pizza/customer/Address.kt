package rafraf70.sandbox.pizza.customer

import jakarta.persistence.Embeddable


@Embeddable
class Address() {
    //
    // --- fields ---
    //

    var street: String? = null
    var postalCode: String? = null
    var city: String? = null

    //
    // --- constructors ---
    //

    constructor(street: String?, postalCode: String?, city: String?) : this() {
        this.street = street
        this.postalCode = postalCode
        this.city = city
    }

    //
    // --- other methods ---
    //
    override fun toString(): String {
        return "Address{" +
                "street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}'
    }
}
