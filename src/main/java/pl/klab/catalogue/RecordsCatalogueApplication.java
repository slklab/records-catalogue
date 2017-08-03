package pl.klab.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // Enables component scanning and auto-configuration
public class RecordsCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordsCatalogueApplication.class, args);
	}
}
