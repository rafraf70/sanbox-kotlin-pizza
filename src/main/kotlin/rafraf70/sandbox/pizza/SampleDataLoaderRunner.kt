package rafraf70.sandbox.pizza

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

/**
 * Performs loading of sample data after the context has started up.
 *
 *
 * We do not want to use @PostConstruct in any SampleDataLoader implementation itself since this
 * caused timing issues when using the default Spring Boot H2 data source. The data could be loaded
 * but wasn't available afterward for querying (empty tables).
 */
@Component
@Order(0)
class SampleDataLoaderRunner(
    @param:Qualifier("small") private val sampleDataLoader: rafraf70.sandbox.pizza.SampleDataLoader
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        sampleDataLoader.run()
    }

}
