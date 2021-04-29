package com.mucahit.customerrelationshipmanager.springdatajpa.service;

import com.mucahit.customerrelationshipmanager.springdatajpa.dao.CustomerRepository;
import com.mucahit.customerrelationshipmanager.springdatajpa.entity.CustomerSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceSpringDataJpaImpl implements CustomerService {

    //inject dao customerdao
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceSpringDataJpaImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override

    public List<CustomerSpringDataJpa> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerSpringDataJpa findById(int theId) {
        Optional<CustomerSpringDataJpa> result = customerRepository.findById(theId);
        CustomerSpringDataJpa customerSpringDataJpa;
        if (result.isPresent())
            customerSpringDataJpa = result.get();
        else
            throw new RuntimeException("Did not find customer id - " + theId);
        return customerSpringDataJpa;
    }

    @Override
    public void save(CustomerSpringDataJpa customerSpringDataJpa) {
        customerRepository.save(customerSpringDataJpa);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);

    }
}
