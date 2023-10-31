package rafraf70.sandbox.pizza.product

interface ProductRepository {

    fun deleteAll()

    fun save(product: Product)

}
