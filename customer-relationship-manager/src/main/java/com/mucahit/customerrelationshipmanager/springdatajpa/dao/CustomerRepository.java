package com.mucahit.customerrelationshipmanager.springdatajpa.dao;

import com.mucahit.customerrelationshipmanager.springdatajpa.entity.CustomerSpringDataJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerSpringDataJpa, Integer> {

}
