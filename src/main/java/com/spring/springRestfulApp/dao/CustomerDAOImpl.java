package com.spring.springRestfulApp.dao;

import com.spring.springRestfulApp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer", Customer.class).getResultList();
        return customerList;
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer deletedCustomer = session.get(Customer.class, theId);
        session.delete(deletedCustomer);
    }
}
