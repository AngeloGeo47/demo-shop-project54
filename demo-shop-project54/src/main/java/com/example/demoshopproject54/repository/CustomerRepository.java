package com.example.demoshopproject54.repository;

import com.example.demoshopproject54.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> getAllCustomersByName(String name);  //select * from customers when customers_name = "Marin"
}
