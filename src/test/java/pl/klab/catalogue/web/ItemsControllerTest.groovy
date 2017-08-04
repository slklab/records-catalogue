package pl.klab.catalogue.web

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.web.client.RestTemplate
import pl.klab.catalogue.RecordsCatalogueApplication
import pl.klab.catalogue.domain.Item
import pl.klab.catalogue.domain.ItemType
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class ItemsControllerTest extends Specification {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context

    void setupSpec() {
        Future future = Executors.newSingleThreadExecutor().submit(new Callable() {
            @Override
            Object call() throws Exception {
                return (ConfigurableApplicationContext) SpringApplication.run(RecordsCatalogueApplication.class)

            }
        })
        context = future.get(60, TimeUnit.SECONDS)
    }

    void "should return one record"(){
        when:
            ArrayList<Item> response = new RestTemplate().getForObject("http://localhost:8080/items", ArrayList.class)

        then:
            response.size() == 2
            assert response.find { it.name == 'Pink Floyd - Dark Side of the Moon' && it.type == ItemType.LP.toString()}
            assert response.find { it.name == 'Clock Machine - Love' && it.type == ItemType.CD.toString()}
    }
}
