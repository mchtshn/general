package com.mucahit.customerrelationshipmanager.jpa.service;

import com.mucahit.customerrelationshipmanager.jpa.entity.CustomerJpa;
import com.mucahit.customerrelationshipmanager.jpa.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceJpaImpl implements CustomerService {

    //inject dao customerdao
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceJpaImpl(@Qualifier("customerDAOJpaImpl") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<CustomerJpa> findAll() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public CustomerJpa findById(int theId) {
        return customerDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(CustomerJpa customerJpa) {
        customerDAO.save(customerJpa);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);

    }
}
