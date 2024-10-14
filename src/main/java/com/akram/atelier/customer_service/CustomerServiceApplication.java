package com.akram.atelier.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.akram.atelier.customer_service.dao.entities.Customer;
import com.akram.atelier.customer_service.dao.repository.CustomerRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.akram.atelier.customer_service.dao.entities")
@EnableJpaRepositories(basePackages = "com.akram.atelier.customer_service.dao.repository")
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
			customerRepository.save(Customer.builder().name("Y").email("Y@gmail.com").build());
		};
    }
}
