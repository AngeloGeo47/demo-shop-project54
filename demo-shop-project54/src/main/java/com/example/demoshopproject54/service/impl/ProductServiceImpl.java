package com.example.demoshopproject54.service.impl;

import com.example.demoshopproject54.model.Product;
import com.example.demoshopproject54.repository.ProductRepository;
import com.example.demoshopproject54.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    //@Autowierd
private final ProductRepository productRepository;

/*public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
}*/
    @Override
    public List<Product> getAllProducts() {
//        List<Product> productList = productRepository.findAll();
//        return productList;
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllProductsByName(name);
    }

    @Override
    public List<Product> getAllProductsByNameAndPrice(String name, double price) {
        return productRepository.findAllProductsByNameAndPrice(name, price);
    }
}
