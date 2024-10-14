package com.akram.atelier.customer_service.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akram.atelier.customer_service.dao.entities.Customer;
import com.akram.atelier.customer_service.service.manager.CustomerManager;


@RestController
public class CustomerRestController {

    @Autowired
    private CustomerManager customerManager;

    @GetMapping("/")
    public ResponseEntity<Map<String, List<Customer>>> customerList() {
        Map<String, List<Customer>> response = new HashMap<>();
        response.put("customers", customerManager.getCustomers());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Customer>> customerById(@PathVariable int id) {
        Map<String, Customer> response = new HashMap<>();
        response.put("customer", customerManager.getCustomerById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/add")
    public String addCustomerForm() {
        return "addCustomer";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer) {
        customerManager.addCustomer(customer);
        return "redirect:/";
    }

}

