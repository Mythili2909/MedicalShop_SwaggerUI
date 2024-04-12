package com.example.Healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Healthcare.model.OrderDetails;
import com.example.Healthcare.service.OrderDetailsService;

@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/getall")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public OrderDetails getOrderDetailsById(@PathVariable Long id) {
        return orderDetailsService.getOrderDetailsById(id);
    }

    @PostMapping("add")
    public OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails) {
        return orderDetailsService.createOrderDetails(orderDetails);
    }

    @PutMapping("/{id}")
    public OrderDetails updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetails orderDetails) {
        return orderDetailsService.updateOrderDetails(id, orderDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetails(@PathVariable Long id) {
        orderDetailsService.deleteOrderDetails(id);
    }
}
