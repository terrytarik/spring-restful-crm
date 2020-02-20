package com.spring.springRestfulApp.service;

import com.spring.springRestfulApp.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(int theId);
    void saveCustomer(Customer theCustomer);
    void deleteCustomer(int theId);
}
