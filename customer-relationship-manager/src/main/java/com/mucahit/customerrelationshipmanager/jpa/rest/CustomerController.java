package com.mucahit.customerrelationshipmanager.jpa.rest;

import com.mucahit.customerrelationshipmanager.jpa.entity.CustomerJpa;
import com.mucahit.customerrelationshipmanager.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class CustomerController {

    //inject customerService
    private CustomerService customerService;

    @Autowired
    public CustomerController(@Qualifier("customerServiceJpaImpl") CustomerService customerService) {
        this.customerService = customerService;
    }

    //expose "/customers" and return list of customers
    @GetMapping("/customers")
    public List<CustomerJpa> listCustomers() {
        return customerService.findAll();
    }

    //expose "/customers/{customerId}" and return list of customers
    @GetMapping("/customers/{customerId}")
    public CustomerJpa getCustomers(@PathVariable int customerId) {
        CustomerJpa customerJpa = customerService.findById(customerId);

        if (customerJpa == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return customerJpa;
    }

    //expose "/customers" to add new customer
    @PostMapping("/customers")
    public void addCustomer(@RequestBody CustomerJpa theCustomerJpa) {
        //this is to  force a save for a new item .... instead of update

        theCustomerJpa.setId(0);

        customerService.save(theCustomerJpa);
    }

    //expose "/customers" to update the customer
    @PutMapping("/customers")
    public void updateCustomer(@RequestBody CustomerJpa theCustomerJpa) {
        customerService.save(theCustomerJpa);
    }

    //expose "/customers" to delete the id
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        CustomerJpa customerJpa = customerService.findById(customerId);

        if (customerJpa == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);

        return String.format("Deleted customer id - %s ", customerId);
    }
}
