package com.mucahit.customerrelationshipmanager.springdatajpa.rest;

import com.mucahit.customerrelationshipmanager.springdatajpa.service.CustomerService;
import com.mucahit.customerrelationshipmanager.springdatajpa.entity.CustomerSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springdatajpa")
public class CustomerSpringDataJpaController {

    //inject customerService
    private CustomerService customerService;

    @Autowired
    public CustomerSpringDataJpaController(@Qualifier("customerServiceSpringDataJpaImpl") CustomerService customerService) {
        this.customerService = customerService;
    }

    //expose "/customers" and return list of customers
    @GetMapping("/customers")
    public List<CustomerSpringDataJpa> listCustomers() {
        return customerService.findAll();
    }

    //expose "/customers/{customerId}" and return list of customers
    @GetMapping("/customers/{customerId}")
    public CustomerSpringDataJpa getCustomers(@PathVariable int customerId) {
        CustomerSpringDataJpa customerSpringDataJpa = customerService.findById(customerId);

        if (customerSpringDataJpa == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return customerSpringDataJpa;
    }

    //expose "/customers" to add new customer
    @PostMapping("/customers")
    public void addCustomer(@RequestBody CustomerSpringDataJpa theCustomerSpringDataJpa) {
        //this is to  force a save for a new item .... instead of update

        theCustomerSpringDataJpa.setId(0);

        customerService.save(theCustomerSpringDataJpa);
    }

    //expose "/customers" to update the customer
    @PutMapping("/customers")
    public void updateCustomer(@RequestBody CustomerSpringDataJpa theCustomerSpringDataJpa) {
        customerService.save(theCustomerSpringDataJpa);
    }

    //expose "/customers" to delete the id
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        CustomerSpringDataJpa customerSpringDataJpa = customerService.findById(customerId);

        if (customerSpringDataJpa == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);

        return String.format("Deleted customer id - %s ", customerId);
    }
}
