package de.freischlag.sandbox.pizza.product

import org.springframework.stereotype.Service

@Service
class ProductService {

    /**
     * Returns the [Product] found or throws [ProductNotFoundException] if not
     * @throws ProductNotFoundException
     */
    fun getProduct(productId: String): Product {
        // todo
        return Product()
    }


    fun createProduct(product: Product) {
        // todo
    }


    fun getTotalPrice(productQuantities: Map<String, Int>): Double {
        // loop over each map entry (which is productId -> quantity) and map each entry to the product's price
        // multiplied by desired quantity. Then sum all up and that is our total.
        // To avoid annoying floating point arithmetic problems we calculate everything in cent and divide later
        // back to full Euro.
        val totalPriceInCent = productQuantities
            .map { entry ->
                val product = getProduct(entry.key)
                (product.price * entry.value * 100).toInt()
            }
            .sum()
        return totalPriceInCent / 100.0
    }

}
