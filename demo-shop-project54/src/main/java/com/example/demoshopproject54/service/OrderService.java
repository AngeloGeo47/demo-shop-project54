package com.example.demoshopproject54.service;

import com.example.demoshopproject54.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrder();

    Optional<Order> getOrderById(Long id);

    Order saveOrder(Order order);

    Order uptateOrder(Order order);

    void deleteOrderById(Long id);

    List<Order> getAllOrdersByName(String name);

}