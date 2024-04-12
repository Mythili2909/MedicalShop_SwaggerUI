package com.example.Healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.model.OrderDetails;
import com.example.Healthcare.repository.OrderDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderDetailsById(Long id) {
        Optional<OrderDetails> optionalOrderDetails = orderDetailsRepository.findById(id);
        return optionalOrderDetails.orElse(null);
    }

    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public OrderDetails updateOrderDetails(Long id, OrderDetails updatedOrderDetails) {
        OrderDetails existingOrderDetails = getOrderDetailsById(id);
        if (existingOrderDetails != null) {
            // Update the properties of the existing order details
            existingOrderDetails.setOrder(updatedOrderDetails.getOrder());
            // existingOrderDetails.setOrderedItem(updatedOrderDetails.getOrderedItem());
            existingOrderDetails.setQuantity(updatedOrderDetails.getQuantity());
            return orderDetailsRepository.save(existingOrderDetails);
        }
        return null;
    }

    public void deleteOrderDetails(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
