package com.spring.springRestfulApp.dao;

import com.spring.springRestfulApp.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    Customer getCustomer(int theId);
    void saveCustomer(Customer theCustomer);
    void deleteCustomer(int theId);
}
