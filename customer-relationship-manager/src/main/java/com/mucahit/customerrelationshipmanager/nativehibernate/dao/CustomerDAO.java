package com.mucahit.customerrelationshipmanager.nativehibernate.dao;

import com.mucahit.customerrelationshipmanager.nativehibernate.entity.CustomerHibernate;

import java.util.List;

public interface CustomerDAO {

    List<CustomerHibernate> findAll();
    CustomerHibernate findById(int theId);
    void save(CustomerHibernate customerHibernate);
    void deleteById(int theId);
}
