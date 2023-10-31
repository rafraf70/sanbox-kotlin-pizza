package de.freischlag.sandbox.pizza.product

interface ProductRepository {

    fun deleteAll()

    fun save(product: Product)

}
