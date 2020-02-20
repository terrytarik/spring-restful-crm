package com.spring.springRestfulApp.controller;


import com.spring.springRestfulApp.errorHandler.CustomerNotFoundException;
import com.spring.springRestfulApp.entity.Customer;
import com.spring.springRestfulApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomerList() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int theId) {
        Customer theCustomer = customerService.getCustomer(theId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found: " + theId);
        }
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int theId) {
        Customer deletedCustomer = customerService.getCustomer(theId);
        if (deletedCustomer == null) {
            return "Customer id found: " + theId;
        }
        customerService.deleteCustomer(theId);
        return "delete customer with id: " + theId;
    }

}
