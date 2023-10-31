package rafraf70.sandbox.pizza.customer

import org.mockito.Mockito
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import rafraf70.sandbox.pizza.SampleDataLoader.SmallDataLoader
import rafraf70.sandbox.pizza.SampleDataLoaderRunner
import rafraf70.sandbox.pizza.product.ProductRepository

@TestConfiguration
@ComponentScan("rafraf70.sandbox.pizza") // to get both service and repository beans
@Import(
    CustomerService::class,
    SampleDataLoaderRunner::class,
    SmallDataLoader::class,
    DataSourceAutoConfiguration::class
)
class CustomerTestContextConfiguration {
    // Demonstrates replacing an existing bean with regular bean definition mechanics.
    // This can be, of course, replaced by just a @MockBean declaration in the test class itself.
    @Bean("productJdbcDao")
    fun mockedProductRepository(): ProductRepository {
        return Mockito.mock(ProductRepository::class.java)
    }
}
