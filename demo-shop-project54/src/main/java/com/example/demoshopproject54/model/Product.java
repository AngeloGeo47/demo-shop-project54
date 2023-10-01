package com.example.demoshopproject54.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name", nullable = false)  // nullable = false inseamna o optiune unde permite in baza de date sa nu am valoare nula
    private String name;
    @Column(name = "product_description", nullable = false)
    private String description;
    @Column(name = "product_price", nullable = false)
    private double price;
    @Column(name = "product_category", nullable = false)
    private String category;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
