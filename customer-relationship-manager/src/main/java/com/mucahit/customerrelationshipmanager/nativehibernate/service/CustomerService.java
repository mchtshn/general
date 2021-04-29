package com.mucahit.customerrelationshipmanager.nativehibernate.service;



import com.mucahit.customerrelationshipmanager.nativehibernate.entity.CustomerHibernate;

import java.util.List;

public interface CustomerService {

    List<CustomerHibernate> findAll();
    CustomerHibernate findById(int theId);
    void save(CustomerHibernate customerHibernate);
    void deleteById(int theId);
}
