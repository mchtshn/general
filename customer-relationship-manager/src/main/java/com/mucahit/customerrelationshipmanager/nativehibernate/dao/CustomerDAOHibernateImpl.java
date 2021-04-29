package com.mucahit.customerrelationshipmanager.nativehibernate.dao;

import com.mucahit.customerrelationshipmanager.nativehibernate.entity.CustomerHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

    //define field for entitymanager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public CustomerDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CustomerHibernate> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<CustomerHibernate> query = currentSession.createQuery("from CustomerHibernate ", CustomerHibernate.class);

        //execute query and get the result
        List<CustomerHibernate> customerHibernates = query.getResultList();

        //return the result
        return customerHibernates;
    }

    @Override
    public CustomerHibernate findById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the customer
        CustomerHibernate customerHibernate = currentSession.get(CustomerHibernate.class, theId);

        //return the customer
        return customerHibernate;
    }

    @Override
    public void save(CustomerHibernate customerHibernate) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save customer
        currentSession.save(customerHibernate);
    }


    @Override
    public void deleteById(int theId) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete customer with theID
        Query theQuery = currentSession.createQuery("delete from CustomerSpringDataJpa where id =: theCustomerId");

        theQuery.setParameter("theCustomerId", theId);

        theQuery.executeUpdate();


    }
}
