package com.akram.atelier.customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akram.atelier.customer_service.dao.entities.Customer;
import com.akram.atelier.customer_service.dao.repository.CustomerRepository;
import com.akram.atelier.customer_service.service.manager.CustomerManager;


@Service
public class CustomerService implements CustomerManager  {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
}
