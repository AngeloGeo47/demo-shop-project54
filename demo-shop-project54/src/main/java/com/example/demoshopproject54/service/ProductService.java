package com.example.demoshopproject54.service;

import com.example.demoshopproject54.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //Read all products from database -> se va mata cu un GET HTTP ENDPOINT
    List<Product> getAllProducts();

    //Read data for a product by id -> se va mapa cu un GET(by id) HTTP ENDPOINT
    Optional<Product> getProductById(Long id);

    //Create new product and save it to database -> POST HTTP ENDPOINT
    Product saveProduct(Product product);

    //Update a product by id -> UPDATE (by ID) HTTP ENDPOINT (atunci cand vrei sa-ti actualizezi pretul unui produs)
    Product updateProduct(Product product);

    //Delete product by id -> DELETE (by ID) HTTP ENDPOINT  (atunci cand vrei sa stergi un produs)
    void deleteProductById(Long id);

    //custom crud method logic
    List<Product> getAllProductsByName(String name);
    List<Product> getAllProductsByNameAndPrice(String name, double price);
}
