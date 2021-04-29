package com.mucahit.customerrelationshipmanager.nativehibernate.service;

import com.mucahit.customerrelationshipmanager.nativehibernate.entity.CustomerHibernate;
import com.mucahit.customerrelationshipmanager.nativehibernate.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceHibernateImpl implements CustomerService {

    //inject dao customerdao
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceHibernateImpl(@Qualifier("customerDAOHibernateImpl") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<CustomerHibernate> findAll() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public CustomerHibernate findById(int theId) {
        return customerDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(CustomerHibernate customerHibernate) {
        customerDAO.save(customerHibernate);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);

    }
}
