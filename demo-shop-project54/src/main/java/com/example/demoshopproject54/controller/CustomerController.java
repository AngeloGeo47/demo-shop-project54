package com.example.demoshopproject54.controller;


import com.example.demoshopproject54.model.Customer;
import com.example.demoshopproject54.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;


    //POST endpoint  http://localhost:8080/api/customers/addNewCustomer
    @PostMapping("/addNewCustomer")
    public ResponseEntity<Customer> addCostumer(@RequestBody Customer customer){
        Customer customerToBeSaved = customerService.saveCustomer(customer);
        return new ResponseEntity<>(customerToBeSaved, HttpStatus.OK);
    }
}
