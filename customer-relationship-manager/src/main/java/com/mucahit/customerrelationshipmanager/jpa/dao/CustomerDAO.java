package com.mucahit.customerrelationshipmanager.jpa.dao;

import com.mucahit.customerrelationshipmanager.jpa.entity.CustomerJpa;

import java.util.List;

public interface CustomerDAO {

    List<CustomerJpa> findAll();
    CustomerJpa findById(int theId);
    void save(CustomerJpa customerJpa);
    void deleteById(int theId);
}
