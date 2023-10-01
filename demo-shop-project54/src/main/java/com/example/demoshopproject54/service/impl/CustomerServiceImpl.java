package com.example.demoshopproject54.service.impl;

import com.example.demoshopproject54.model.Customer;
import com.example.demoshopproject54.repository.CustomerRepository;
import com.example.demoshopproject54.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService {

    @Autowired

    private  CustomerRepository customerRepository;

    // CRUD = CREATE(POST), READ(GET), UPDATE(PUT), DELETE(DELETE) (acestea toate sunt metodele CRUD)

    // Read = GET http method
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList= customerRepository.findAll();
        return customerList;  //sau scriem direct return customerRepository.findAll();
    }


    // Read = GET http method
    @Override
    public Optional<Customer> getCustomerById(Long id) {

        return customerRepository.findById(id);
    }


    // Create = SAVE => POST http method
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    // Update = SAVE => PUT http method
    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    // Delete = DELETE => DELETE http method
    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }


    // Read = GET http method
    @Override
    public List<Customer> getAllCustomersByName(String name) {
        return customerRepository.getAllCustomersByName(name);
    }


    // Read = GET http method
    @Override
    public List<Customer> getAllCustomersByNameAndPhone(String name, String phone) {
        return null;
    }
}