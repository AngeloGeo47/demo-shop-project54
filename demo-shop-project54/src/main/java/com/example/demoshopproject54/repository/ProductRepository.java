package com.example.demoshopproject54.repository;

import com.example.demoshopproject54.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllProductsByName(String name);
    List<Product> findAllProductsByNameAndPrice(String name, double price);
}
