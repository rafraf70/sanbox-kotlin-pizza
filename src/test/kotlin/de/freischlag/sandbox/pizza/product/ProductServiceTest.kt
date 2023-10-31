package de.freischlag.sandbox.pizza.product

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private lateinit var productService: ProductService

    @Test
    fun getProduct() {
        // given -- data created by sample-data-loader
        val productId = "S-01"

        // when
        val product = productService.getProduct(productId)

        // then
        assertThat(product.productId).isEqualTo(productId)
        assertThat(product.name).isEqualTo("Thunfisch Salat")
        assertThat(product.price).isEqualTo(6.90)
    }


    @Test
    fun createProduct() {
        // given
        val productId = "XYZ-123"
        val name = "The Product"
        val price = 123.456
        val productToCreate = Product(
            productId = productId,
            name = name,
            price = price,
        )

        // when
        productService.createProduct(productToCreate)
        val product = productService.getProduct(productId)

        // then
        assertThat(product.productId).isEqualTo(productId)
        assertThat(product.name).isEqualTo(name)
        assertThat(product.price).isEqualTo(price)
    }
}
