package com.mucahit.customerrelationshipmanager.jpa.service;



import com.mucahit.customerrelationshipmanager.jpa.entity.CustomerJpa;

import java.util.List;

public interface CustomerService {

    List<CustomerJpa> findAll();
    CustomerJpa findById(int theId);
    void save(CustomerJpa customerHibernate);
    void deleteById(int theId);
}
