package com.example.demoshopproject54.service;

import com.example.demoshopproject54.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //Read all customers from database->se mapeaza cu request de get- GET
    List<Customer> getAllCustomers();

    //read data for a customer by id-se va mapa tot cu GET by id
    Optional<Customer> getCustomerById(Long id);

    //create new customer and save it to database-POST
    Customer saveCustomer(Customer customer);

    //Update a customer by id-UPDATE
    Customer updateCustomer(Customer customer);


    //delete customer by Id -DELETE
    void deleteCustomerById(Long id);

    //custom crud methods logic
    List<Customer> getAllCustomersByName(String name);

    List<Customer> getAllCustomersByNameAndPhone(String name, String phone);

}