package com.akram.atelier.customer_service.service.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.akram.atelier.customer_service.dao.entities.Customer;

@Component
public interface CustomerManager {
        List<Customer> getCustomers();
        Customer getCustomerById(int id); 
        Customer addCustomer(Customer customer); 
}
