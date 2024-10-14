package com.akram.atelier.customer_service.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akram.atelier.customer_service.dao.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
