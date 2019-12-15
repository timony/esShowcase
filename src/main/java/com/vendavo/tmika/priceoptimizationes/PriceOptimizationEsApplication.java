package com.vendavo.tmika.priceoptimizationes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PriceOptimizationEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceOptimizationEsApplication.class, args);
	}

}
