package pl.klab.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@SpringBootApplication // Enables component scanning and auto-configuration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class RecordsCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordsCatalogueApplication.class, args);
	}
}
