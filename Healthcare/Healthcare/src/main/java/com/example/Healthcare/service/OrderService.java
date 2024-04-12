package com.example.Healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.model.Order;
import com.example.Healthcare.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);
        if (existingOrder != null) {
            // Update the properties of the existing order
            // existingOrder.setOrderId(updatedOrder.getOrderId());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setAmount(updatedOrder.getAmount());
            existingOrder.setPaymentType(updatedOrder.getPaymentType());
            existingOrder.setHealthModel(updatedOrder.getHealthModel());
            existingOrder.setOrderDetails(updatedOrder.getOrderDetails());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
