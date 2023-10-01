package com.example.demoshopproject54.controller;

import com.example.demoshopproject54.exception.ResourceNotFoundException;
import com.example.demoshopproject54.model.Product;
import com.example.demoshopproject54.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products") // base url
public class ProductController {

    // Implement HTTP rest APIs: GET, POST, PUT, DELETE.
    // Dependencing Injection using @RequiredArgsConstructor
    private final ProductService productService;

    // GET endpoints //http://localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    //GET endpoint //http://localhost:8080/api/products
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> readProductById(@PathVariable Long id) {
        Product productFromDB = productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id" + id + " doesn't exist in database!"));
        return new ResponseEntity<>(productFromDB, HttpStatus.OK); //200 ok
    }

    //GET endpoint  //http://localhost:8080/api/products/getProductByName/name
    @GetMapping("/getAllProductsByName/{name}")
    public ResponseEntity<List<Product>> readAllProductByName(@PathVariable String name) {
        List<Product> productListFromDB = productService.getAllProductsByName(name);

        if (productListFromDB.isEmpty()) {
            throw new ResourceNotFoundException("No products with name " + name + "not found!");
        }
        return new ResponseEntity<>(productListFromDB, HttpStatus.OK);
    }

    //GET endpoint  //http://localhost:8080/api/products/getAllProductsByNameAndPrice/name = '' & price = ''
    @GetMapping("/getAllProductsByNameAndPrice/{name}/{price}")
    public ResponseEntity<List<Product>> readAllProductByNameAndPrice(@PathVariable String name, @PathVariable double price) {
        List<Product> productListFromDB = productService.getAllProductsByNameAndPrice(name, price);

        if (productListFromDB.isEmpty()) {
            throw new ResourceNotFoundException("No products with name " + name + "not found!");
        }
        return new ResponseEntity<>(productListFromDB, HttpStatus.OK);
    }

    //POST endpoint  http://localhost:8080/api/products/addNewProduct
    @PostMapping("/addNewProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product productToBeSaved = productService.saveProduct(product);
        return new ResponseEntity<>(productToBeSaved, HttpStatus.OK);
    }

    //PUT endpoint  //http://localhost:8080/api/products/updateProduct
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        //return ResponseEntity.ok(updateProduct);   //cele 2 returnuri sunt niste alternative de prescurtare
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    //DELETE endpoint  //http://localhost:8080/api/products/updateProduct
    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> removeProductById(@PathVariable Long id) {
        productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id" + id + " doesn't exist in database!"));

        productService.deleteProductById(id);

        return new ResponseEntity<>("Product with id " + id + " deleted!", HttpStatus.OK);
    }
}