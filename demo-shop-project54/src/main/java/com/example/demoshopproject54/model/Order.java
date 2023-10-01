package com.example.demoshopproject54.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "order_id")
    private Long id;
    @Column(name = "order_name", nullable = false)
    private String name;
    @Column(name = "order_no", nullable = false)
    private int orderNo;
    @Column(name = "order_status", nullable = false)
    private String status;
    @Column(name = "order_quantity", nullable = false)
    private int quantity;
    @Column(name = "order_orderDate", nullable = false)
    private LocalDate orderDate;
    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
