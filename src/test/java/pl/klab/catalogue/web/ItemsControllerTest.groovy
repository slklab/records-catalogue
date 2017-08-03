package pl.klab.catalogue.web

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import pl.klab.catalogue.RecordsCatalogueApplication
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
    ConfigurableApplicationContext context;

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
            def responseEntity = new RestTemplate().getForEntity("http://localhost:8080/items", String.class)

        then:
            responseEntity.statusCode == HttpStatus.OK
            responseEntity.body.contains("SAMPLE ITEM")
    }

}
