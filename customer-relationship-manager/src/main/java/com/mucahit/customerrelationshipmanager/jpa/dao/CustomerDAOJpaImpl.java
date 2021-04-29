package com.mucahit.customerrelationshipmanager.jpa.dao;

import com.mucahit.customerrelationshipmanager.jpa.entity.CustomerJpa;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

    //define field for entitymanager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public CustomerDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CustomerJpa> findAll() {

        //create a query
        Query query = entityManager.createQuery("from CustomerJpa");

        //execute query and get the result
        List<CustomerJpa> customerJpas = query.getResultList();

        //return the result
        return customerJpas;
    }

    @Override
    public CustomerJpa findById(int theId) {

        //get the customer
        CustomerJpa customerJpa = entityManager.find(CustomerJpa.class, theId);

        //return the customer
        return customerJpa;
    }

    @Override
    public void save(CustomerJpa customerJpa) {

        //save or update customer
        CustomerJpa dbCustomerJpa = entityManager.merge(customerJpa);

        //update with id from db ...  so we can get generated id for save/insert
        customerJpa.setId(dbCustomerJpa.getId());
    }


    @Override
    public void deleteById(int theId) {
        //delete customer with theID
        Query theQuery = entityManager.createQuery("delete from CustomerJpa where id =: theCustomerId");

        theQuery.setParameter("theCustomerId", theId);

        theQuery.executeUpdate();


    }
}
