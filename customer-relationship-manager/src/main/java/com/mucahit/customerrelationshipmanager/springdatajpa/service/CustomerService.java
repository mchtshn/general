package com.mucahit.customerrelationshipmanager.springdatajpa.service;


import com.mucahit.customerrelationshipmanager.springdatajpa.entity.CustomerSpringDataJpa;

import java.util.List;

public interface CustomerService {

    List<CustomerSpringDataJpa> findAll();

    CustomerSpringDataJpa findById(int theId);

    void save(CustomerSpringDataJpa customerSpringDataJpa);

    void deleteById(int theId);
}
