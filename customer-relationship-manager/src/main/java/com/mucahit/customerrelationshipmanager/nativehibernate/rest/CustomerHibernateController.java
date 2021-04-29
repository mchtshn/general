package com.mucahit.customerrelationshipmanager.nativehibernate.rest;

import com.mucahit.customerrelationshipmanager.nativehibernate.entity.CustomerHibernate;
import com.mucahit.customerrelationshipmanager.nativehibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hibernate")
public class CustomerHibernateController {

    //inject customerService
    private CustomerService customerService;

    @Autowired
    public CustomerHibernateController(@Qualifier("customerServiceHibernateImpl") CustomerService customerService) {
        this.customerService = customerService;
    }

    //expose "/customers" and return list of customers
    @GetMapping("/customers")
    public List<CustomerHibernate> listCustomers() {
        return customerService.findAll();
    }

    //expose "/customers/{customerId}" and return list of customers
    @GetMapping("/customers/{customerId}")
    public CustomerHibernate getCustomers(@PathVariable int customerId) {
        CustomerHibernate customerHibernate = customerService.findById(customerId);

        if (customerHibernate == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return customerHibernate;
    }

    //expose "/customers" to add new customer
    @PostMapping("/customers")
    public void addCustomer(@RequestBody CustomerHibernate theCustomerHibernate) {
        //this is to  force a save for a new item .... instead of update

        theCustomerHibernate.setId(0);

        customerService.save(theCustomerHibernate);
    }

    //expose "/customers" to update the customer
    @PutMapping("/customers")
    public void updateCustomer(@RequestBody CustomerHibernate theCustomerHibernate) {
        customerService.save(theCustomerHibernate);
    }

    //expose "/customers" to delete the id
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        CustomerHibernate customerHibernate = customerService.findById(customerId);

        if (customerHibernate == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);

        return String.format("Deleted customer id - %s ", customerId);
    }
}
